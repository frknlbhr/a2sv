package com.ilbahar.a2sv.leetcode.heap._1642;

import java.util.PriorityQueue;

/**
 * @author filbahar
 * @created 28.02.2022
 */
public class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights.length == 1) return 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            int dif = heights[i] - heights[i - 1];
            if (dif > 0) {
                heap.add(-dif);
                bricks = bricks - dif;
                if (bricks < 0 && ladders == 0) {
                    return i - 1;
                }
                if (bricks < 0 && ladders > 0) {
                    bricks += heap.poll() * -1;
                    ladders--;
                }
            }
        }
        return heights.length - 1;
    }

}
