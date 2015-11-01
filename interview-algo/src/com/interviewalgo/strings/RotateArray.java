package com.interviewalgo.strings;

/**
 * Problem: Rotate an array of n elements to the right by k steps. For example,
 * with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4]. How many different ways do you know to solve this problem?
 * 
 * @author ksingh
 * 
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] num1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] num2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] num3 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 2;

        intermediateArrayRotate(num1, k);
        bubbleRotate(num2, k);
        reversalRotate(num3, k);

        System.out.println("Intermediate array : ");
        for (int i : num1) {
            System.out.print(i + ", ");
        }

        System.out.println();
        System.out.println("Bubble array : ");
        for (int i : num2) {
            System.out.print(i + ", ");
        }

        System.out.println();
        System.out.println("Reversal array : ");
        for (int i : num3) {
            System.out.print(i + ", ");
        }
    }

    private static void intermediateArrayRotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        int[] result = new int[nums.length];

        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }

        int j = 0;
        for (int i = k; i < nums.length; i++) {
            result[i] = nums[j++];
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    private static void bubbleRotate(int[] nums, int k) {
        if (nums == null || k < 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }

    /**
     * Can we do this in O(1) space and in O(n) time? The following solution
     * does.
     * 
     * Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:
     * 
     * 1. Divide the array two parts: 1,2,3,4 and 5, 6 2. Rotate first part:
     * 4,3,2,1,5,6 3. Rotate second part: 4,3,2,1,6,5 4. Rotate the whole array:
     * 5,6,1,2,3,4
     * 
     * @param nums
     * @param k
     */
    private static void reversalRotate(int[] nums, int k) {
        k = k % nums.length;

        if (nums == null || k < 0) {
            throw new IllegalArgumentException();
        }

        // length of first part
        int a = nums.length - k;

        reverse(nums, 0, a - 1);
        reverse(nums, a, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private static void reverse(int[] nums, int left, int right) {
        if (nums == null || nums.length == 1) {
            return;
        }

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
