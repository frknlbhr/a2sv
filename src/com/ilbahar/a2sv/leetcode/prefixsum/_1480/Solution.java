package com.ilbahar.a2sv.leetcode.prefixsum._1480;

public class Solution {

    public int[] runningSum(int[] nums) {

        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }
        return runningSum;
    }

}
