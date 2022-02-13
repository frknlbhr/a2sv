package com.ilbahar.a2sv.leetcode.array._26;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }

}
