package com.ilbahar.a2sv.leetcode.sorting._1365;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        Map<Integer, Integer> numberAndIndexMap = new HashMap<>();
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        for (int i = 0; i < nums.length; i++) {
            if (!numberAndIndexMap.containsKey(sortedNums[i])) {
                numberAndIndexMap.put(sortedNums[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = numberAndIndexMap.get(nums[i]);
        }
        return sortedNums;
    }

}
