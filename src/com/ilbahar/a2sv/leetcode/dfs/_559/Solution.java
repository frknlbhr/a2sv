package com.ilbahar.a2sv.leetcode.dfs._559;

import com.ilbahar.a2sv.leetcode.dfs.Node;

import java.util.PriorityQueue;

/**
 * @author filbahar
 * @created 1.03.2022
 */
public class Solution {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        dfs(root, heap, 0);
        return heap.peek() * -1;
    }

    private void dfs(Node node, PriorityQueue<Integer> heap, int depth) {
        depth++;
        if (node != null && node.children == null || node.children.size() == 0) {
            heap.add(depth * -1);
        }
        for (Node child : node.children) {
            dfs(child, heap, depth);
        }
    }

}
