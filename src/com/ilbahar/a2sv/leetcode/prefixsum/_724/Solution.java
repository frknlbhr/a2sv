package com.ilbahar.a2sv.leetcode.prefixsum._724;

import java.util.Arrays;

public class Solution {

    public int pivotIndex(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        int leftTotal = 0;
        int rightTotal = sum;

        for (int i = 0; i < nums.length; i++) {
            rightTotal -= nums[i];
            if (leftTotal == rightTotal) {
                return i;
            }
            leftTotal += nums[i];
        }
        return -1;
    }

}
