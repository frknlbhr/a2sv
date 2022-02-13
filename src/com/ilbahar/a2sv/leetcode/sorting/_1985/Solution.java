package com.ilbahar.a2sv.leetcode.sorting._1985;

import java.util.Arrays;

public class Solution {

    public String kthLargestNumber(String[] nums, int k) {

        for (int i = 0; i<nums.length; i++) {
            nums[i] = pushZeros(nums[i]);
        }

        Arrays.sort(nums);

        return removeLeadingZeros(nums[nums.length - k]);
    }

    public String pushZeros(String num) {
        int size = num.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100 - size; i++) {
            sb.append("0");
        }
        sb.append(num);
        return sb.toString();
    }

    public String removeLeadingZeros(String num) {

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                return num.substring(i, num.length());
            }
        }
        return "0";
    }

}
