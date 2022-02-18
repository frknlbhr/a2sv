package com.ilbahar.a2sv.leetcode.prefixsum._1413;

public class Solution {

    public int minStartValue(int[] nums) {

        int min = 100;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
            if (total < min) {
                min = total;
            }
        }
        return min <= 0 ? (1 - min) : 1;
    }

}
