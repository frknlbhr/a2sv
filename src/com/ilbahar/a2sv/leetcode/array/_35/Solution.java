package com.ilbahar.a2sv.leetcode.array._35;

public class Solution {

    public int searchInsert(int[] nums, int target) {

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while(leftIndex <= rightIndex){
            int mid = (leftIndex + rightIndex) / 2;

            if(target > nums[mid]){
                leftIndex = mid + 1;
            }else if(target < nums[mid]){
                rightIndex = mid - 1;
            }else{
                return mid;
            }
        }
        return leftIndex;
    }

}
