package com.ilbahar.a2sv.leetcode.sorting._75;

public class Solution {

    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int currentIndex = 0;

        while (currentIndex <= twoIndex) {
            if (nums[currentIndex] == 0) {
                swap(nums, currentIndex, zeroIndex);
                currentIndex++;
                zeroIndex++;
            } else if (nums[currentIndex] == 2) {
                swap(nums, currentIndex, twoIndex);
                twoIndex--;
            } else {
                currentIndex++;
            }
        }
    }

    private void swap(int[] nums, int indexOne, int indexTwo) {
        int temp = nums[indexTwo];
        nums[indexTwo] = nums[indexOne];
        nums[indexOne] = temp;
    }

}
