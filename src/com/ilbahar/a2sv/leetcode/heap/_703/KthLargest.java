package com.ilbahar.a2sv.leetcode.heap._703;

import java.util.PriorityQueue;

/**
 * @author filbahar
 * @created 24.02.2022
 */
public class KthLargest {

    private PriorityQueue<Integer> heap;
    private int k;
    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<Integer>();
        this.k = k;
        this.nums = nums;
        fillHeapWithNums();
        removeIfSizeIsGreaterThanK();
    }

    public int add(int val) {
        heap.add(val);
        removeIfSizeIsGreaterThanK();
        return heap.peek();
    }

    private void fillHeapWithNums() {
        if (nums != null && nums.length != 0) {
            for (int num : nums) {
                heap.add(num);
            }
        }
    }

    private void removeIfSizeIsGreaterThanK() {
        while (heap.size() > k) {
            heap.remove();
        }
    }

}
