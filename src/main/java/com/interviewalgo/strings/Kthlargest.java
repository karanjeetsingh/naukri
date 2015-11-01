package com.interviewalgo.strings;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 *
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 <= k <= array's length.
 * 
 * @author kanwal
 *
 */

public class Kthlargest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1,4,3,2,7,9,5,8,6};
        int k = 2;
        System.out.println("Array - " + Arrays.toString(nums));

        System.out.println(findKthLargest(nums, k));
        
    }
    
    public static int findKthLargest(int[] nums, int k){
        if(k == 0 || nums == null)
        {
            return 0;
        }
        else
        {
            return kthLargest(nums.length - k + 1, nums, 0, nums.length -1); 
        }
    }
    
    public static int kthLargest(int k, int[] nums, int start, int end){
        int left =  start;
        int right = end;
        int pivot = nums[right];
        
        while(left < right){
            while(nums[left]< pivot)
                left++;
            while(nums[right]>=pivot)
                right--;
            swap(nums, left, right);
        }
        
        swap(nums, left, end);
        
        if(k == left + 1)
            return nums[k];
        else if(k < left+1)
            return kthLargest(k, nums, start, left - 1);
        else 
            return kthLargest(k, nums, left + 1, right);
        
    }
    
    public static void swap(int[] nums, int left, int right){
        int temp;
        temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
