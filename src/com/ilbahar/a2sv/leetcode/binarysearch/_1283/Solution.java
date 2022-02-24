package com.ilbahar.a2sv.leetcode.binarysearch._1283;

import java.util.Arrays;

/**
 * @author filbahar
 * @created 24.02.2022
 */
public class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        int length = nums.length;
        Arrays.sort(nums);
        int maxValue = nums[length - 1];

        int left = 1;
        int right = maxValue;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sumOfDivisions(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                if (mid == 1 || sumOfDivisions(nums, mid - 1) > threshold) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return 1;
    }

    private int sumOfDivisions(int[] nums, int divisor) {
        int result = 0;
        for (int num : nums) {
            if (num % divisor != 0) {
                result += num / divisor + 1;
            } else {
                result += num / divisor;
            }
        }
        return result;
    }

}
