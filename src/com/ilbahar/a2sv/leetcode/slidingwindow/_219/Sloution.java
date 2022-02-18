package com.ilbahar.a2sv.leetcode.slidingwindow._219;

import java.util.HashSet;
import java.util.Set;

public class Sloution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        Set<Integer> subsetOfNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                if (!subsetOfNums.contains(nums[i])) {
                    subsetOfNums.add(nums[i]);
                } else {
                    return true;
                }
            } else {
                if (subsetOfNums.contains(nums[i])) {
                    return true;
                } else {
                    subsetOfNums.remove(nums[i - k]);
                    subsetOfNums.add(nums[i]);
                }
            }
        }
        return false;
    }

}
