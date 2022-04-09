package com.ilbahar.a2sv.leetcode.bfs._637;

import com.ilbahar.a2sv.leetcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> resultList = new ArrayList<>();

        while (queue.size() > 0) {
            double levelLength = queue.size();
            double totalValOfLevel = 0;
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();
                totalValOfLevel += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resultList.add(totalValOfLevel / levelLength);
        }

        return resultList;
    }

}
