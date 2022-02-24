package com.ilbahar.a2sv.leetcode.binarysearch._34;

/**
 * @author filbahar
 * @created 24.02.2022
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstOrLastIndex(nums, target, true);
        result[1] = findFirstOrLastIndex(nums, target, false);
        return result;
    }

    private int findFirstOrLastIndex(int[] nums, int target, boolean firstIndex) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (firstIndex) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

}
