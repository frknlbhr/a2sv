package com.ilbahar.a2sv.leetcode.array._1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int necessaryValue = target - nums[i];
            numsMap.remove(nums[i], i);
            if (numsMap.containsKey(necessaryValue)) {
                result[0] = i;
                result[1] = numsMap.get(necessaryValue);
                break;
            }
            numsMap.put(nums[i], i);
        }
        return result;
    }

}
