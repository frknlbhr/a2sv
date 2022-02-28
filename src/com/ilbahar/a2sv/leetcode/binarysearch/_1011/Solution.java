package com.ilbahar.a2sv.leetcode.binarysearch._1011;

/**
 * @author filbahar
 * @created 28.02.2022
 */
public class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 500 * weights.length;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (checkCapacityIsValid(mid, weights, days) && !checkCapacityIsValid(mid - 1, weights, days)) {
                return mid;
            } else if (checkCapacityIsValid(mid, weights, days)) {
                right = mid - 1;
            } else if (!checkCapacityIsValid(mid, weights, days)) {
                left = mid + 1;
            }
        }
        return weights[0];
    }

    private boolean checkCapacityIsValid(int capacity, int[] weights, int days) {
        int weightOfDay = 0;
        for (int i = 0; i < weights.length; i++) {
            if (capacity < weights[i]) return false;
            weightOfDay += weights[i];
            if (weightOfDay > capacity) {
                days--;
                weightOfDay = weights[i];
                while (weightOfDay >= capacity) {
                    days--;
                    weightOfDay -= capacity;
                }
            }
            if (days == 0 && i <= weights.length - 1) {
                return false;
            }
        }
        return true;
    }

}
