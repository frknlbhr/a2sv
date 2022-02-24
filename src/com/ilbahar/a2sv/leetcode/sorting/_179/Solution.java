package com.ilbahar.a2sv.leetcode.sorting._179;

import java.util.Arrays;

/**
 * @author filbahar
 * @created 24.02.2022
 */
public class Solution {

    public String largestNumber(int[] nums) {

        String[] numsAsString = new String[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            numsAsString[i] = String.valueOf(nums[i]);
            total += nums[i];
        }
        if (total == 0) {
            return "0";
        }

        Arrays.sort(numsAsString, (o1, o2) -> {
            String output1 = o1 + o2;
            String output2 = o2 + o1;
            return output2.compareTo(output1);
        });

        StringBuilder result = new StringBuilder();
        for (String s : numsAsString) {
            result.append(s);
        }
        return result.toString();
    }

}
