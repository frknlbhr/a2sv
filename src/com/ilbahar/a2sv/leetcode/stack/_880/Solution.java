package com.ilbahar.a2sv.leetcode.stack._880;

public class Solution {

    public String decodeAtIndex(String s, int k) {
        if (k == 1) return String.valueOf(s.charAt(0));

        long decodedStringSize = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                decodedStringSize = decodedStringSize * (c - '0');
            } else {
                decodedStringSize++;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= decodedStringSize;
            if (Character.isLetter(c) && (k == decodedStringSize || k == 0)) {
                return Character.toString(c);
            }
            if (Character.isDigit(c)) {
                decodedStringSize = decodedStringSize / (c - '0');
            } else {
                decodedStringSize--;
            }
        }
        return null;
    }

}
