package com.interviewalgo.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * For example:
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author ksingh
 * 
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 13 };
        int target = 9;
        int[] ret1 = twoSum_1(numbers, target);
        System.out.println(ret1[0] + ", " + ret1[1]);

        int[] ret2 = twoSum_2(numbers, target);
        System.out.println(ret2[0] + ", " + ret2[1]);
    }

    /**
     * Look through all the possible combinations to see if they add up to the
     * target number. The time complexity is O(n^2)
     * 
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum_1(int[] numbers, int target) {
        int[] ret = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    ret[0] = i + 1;
                    ret[1] = j + 1;
                    break;
                }
            }
        }

        return ret;
    }

    /**
     * Use hashmap to save the target value. The complexity depends upon the
     * input output of hashmap, which is usually O(1). So, the total time
     * complexity is O(n).
     * 
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum_2(int[] numbers, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> numbersMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbersMap.containsKey(numbers[i])) {
                int index = numbersMap.get(numbers[i]);
                ret[0] = index + 1;
                ret[1] = i + 1;
                break;
            } else {
                numbersMap.put(target - numbers[i], i);
            }
        }
        return ret;
    }
}
