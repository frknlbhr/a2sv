package com.ilbahar.a2sv.leetcode.binarysearch._275;

/**
 * @author filbahar
 * @created 24.02.2022
 */
public class Solution {

    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int hIndex = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                hIndex = citations.length - mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return hIndex;
    }

}
