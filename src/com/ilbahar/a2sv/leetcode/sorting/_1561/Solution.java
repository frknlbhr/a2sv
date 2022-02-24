package com.ilbahar.a2sv.leetcode.sorting._1561;

import java.util.Arrays;

/**
 * @author filbahar
 * @created 24.02.2022
 */
public class Solution {

    public int maxCoins(int[] piles) {
        int length = piles.length;
        Arrays.sort(piles);
        int indexAfterBob = length / 3;

        int result = 0;
        for (int i = indexAfterBob; i < length; i = i + 2) {
            result += piles[i];
        }
        return result;
    }

}
