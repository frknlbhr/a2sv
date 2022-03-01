package com.ilbahar.a2sv.leetcode.dfs;

import java.util.List;

/**
 * @author filbahar
 * @created 1.03.2022
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
