package com.ilbahar.a2sv.leetcode.stack._121;

public class Solution {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > result) {
                result = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return result;
    }

}
