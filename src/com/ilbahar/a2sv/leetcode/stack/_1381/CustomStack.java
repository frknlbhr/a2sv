package com.ilbahar.a2sv.leetcode.stack._1381;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {

    private final List<Integer> integerList;
    private final int maxSize;

    public CustomStack(int maxSize) {
        this.integerList = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (integerList.size() < maxSize) {
            integerList.add(x);
        }
    }

    public int pop() {
        if (integerList.isEmpty())
            return -1;
        return integerList.remove(integerList.size() - 1);
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(integerList.size(), k); i++) {
            integerList.set(i, integerList.get(i) + val);
        }
    }

}
