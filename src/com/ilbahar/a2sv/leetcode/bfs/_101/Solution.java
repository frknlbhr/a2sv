package com.ilbahar.a2sv.leetcode.bfs._101;

import com.ilbahar.a2sv.leetcode.dfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (queue.size() > 0) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null)
                continue;
            else if (node1 == null || node2 == null)
                return false;
            else if (node1.val != node2.val)
                return false;

            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

}
