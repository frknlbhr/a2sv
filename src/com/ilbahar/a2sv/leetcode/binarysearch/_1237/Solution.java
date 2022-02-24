package com.ilbahar.a2sv.leetcode.binarysearch._1237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author filbahar
 * @created 24.02.2022
 */
public class Solution {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> pairList = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            int y = searchY(x, z, customfunction);
            if (y != -1) {
                List<Integer> pair = new ArrayList<>(Arrays.asList(x, y));
                pairList.add(pair);
            }
        }
        return pairList;
    }

    private int searchY(int x, int z, CustomFunction customFunction) {
        int left = 1;
        int right = 1000;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (customFunction.f(x, mid) == z) {
                return mid;
            } else if (customFunction.f(x, mid) < z) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
