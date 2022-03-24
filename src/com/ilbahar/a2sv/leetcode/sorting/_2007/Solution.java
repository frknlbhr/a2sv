package com.ilbahar.a2sv.leetcode.sorting._2007;

import java.util.*;

public class Solution {

    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if (len%2 != 0) return new int[0];

        Arrays.sort(changed);

        Map<Integer, Integer> numberAndCountMap = new HashMap<>();
        for (int num : changed) {
            if (numberAndCountMap.containsKey(num)) {
                numberAndCountMap.put(num, numberAndCountMap.get(num) + 1);
            } else {
                numberAndCountMap.put(num, 1);
            }
        }

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < changed.length; i++) {
            int num = changed[i];
            int duplicate = num * 2;
            if (numberAndCountMap.get(num) == 0) {
                continue;
            }
            if (numberAndCountMap.containsKey(duplicate) && numberAndCountMap.get(duplicate) > 0) {
                resultList.add(num);
                numberAndCountMap.put(num, numberAndCountMap.get(num) - 1);
                numberAndCountMap.put(duplicate, numberAndCountMap.get(duplicate) - 1);
            } else {
                return new int[0];
            }
        }
        return resultList.stream().mapToInt(a -> (int)a).toArray();
    }

}
