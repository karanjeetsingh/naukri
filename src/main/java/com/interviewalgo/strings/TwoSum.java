package com.interviewalgo.strings;

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
        int[] ret = twoSum_1(numbers, target);
        System.out.println(ret[0] + ", " + ret[1]);
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
}
