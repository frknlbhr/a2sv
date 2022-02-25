package com.ilbahar.a2sv.leetcode.heap._1046;

import java.util.PriorityQueue;

/**
 * @author filbahar
 * @created 25.02.2022
 */
public class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = initializeMaxHeapWithValues(stones);

        while (heap.size() > 1) {
            int heaviest = heap.poll() * -1;
            int secondHeaviest = heap.poll() * -1;
            int smashResult = smash(secondHeaviest, heaviest);
            if (smashResult != 0) {
                heap.add(smashResult * -1);
            }
        }
        return heap.peek() != null ? heap.peek() * -1 : 0;
    }


    private int smash(int x, int y) {
        return y - x;
    }

    private PriorityQueue<Integer> initializeMaxHeapWithValues(int[] values) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int value : values) {
            heap.add(value * -1);
        }
        return heap;
    }

}
