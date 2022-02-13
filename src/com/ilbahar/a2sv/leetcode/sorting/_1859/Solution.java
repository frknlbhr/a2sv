package com.ilbahar.a2sv.leetcode.sorting._1859;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String sortSentence(String s) {
        String[] words = s.split(" ");
        Map<Integer, String> indexAndWordMap = new HashMap<>();
        for (String word : words) {
            indexAndWordMap.put(Integer.valueOf(word.substring(word.length() - 1)), word.substring(0, word.length() - 1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= words.length; i++) {
            sb.append(indexAndWordMap.get(i));
            if (i != words.length)
                sb.append(" ");
        }
        return sb.toString();
    }

}
