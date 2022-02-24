package com.ilbahar.a2sv.leetcode.binarysearch._1351;

/**
 * @author filbahar
 * @created 24.02.2022
 */
public class Solution {

    // O(m*log(n))
    public int countNegatives(int[][] grid) {
        int result = 0;
        for (int[] row : grid) {
            result += findNumberOfNegatives(row);
        }
        return result;
    }

    private int findNumberOfNegatives(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                if (mid == 0 || nums[mid - 1] >= 0) {
                    return nums.length - mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

}
