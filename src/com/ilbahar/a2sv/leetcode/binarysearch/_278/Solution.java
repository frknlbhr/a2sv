package com.ilbahar.a2sv.leetcode.binarysearch._278;

/**
 * @author filbahar
 * @created 24.02.2022
 */
public class Solution {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
                if (mid == 1 || !isBadVersion(mid - 1)) {
                    return mid;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }






    private boolean isBadVersion(int n) {
        return true;
    }

}
