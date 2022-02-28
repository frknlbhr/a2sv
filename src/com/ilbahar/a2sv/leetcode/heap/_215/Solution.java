package com.ilbahar.a2sv.leetcode.heap._215;

import java.util.PriorityQueue;

/**
 * @author filbahar
 * @created 28.02.2022
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int num : nums) {
            minHeap.add(num * -1);
        }
        while (k != 1) {
            minHeap.remove();
            k--;
        }
        return minHeap.peek() * -1;
    }

}
