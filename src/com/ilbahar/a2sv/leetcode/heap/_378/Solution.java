package com.ilbahar.a2sv.leetcode.heap._378;

import java.util.PriorityQueue;

/**
 * @author filbahar
 * @created 28.02.2022
 */
public class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                minHeap.add(ints[j]);
            }
        }
        while (k != 1) {
            minHeap.remove();
            k--;
        }
        return minHeap.peek();
    }

}
