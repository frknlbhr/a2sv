package com.ilbahar.a2sv.leetcode.dfs._112;

import com.ilbahar.a2sv.leetcode.dfs.TreeNode;

/**
 * @author filbahar
 * @created 1.03.2022
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode treenode, int targetSum) {
        if (treenode == null) return false;

        if (treenode.left == null && treenode.right == null && targetSum == treenode.val) {
            return true;
        }

        return dfs(treenode.left, targetSum - treenode.val) || dfs(treenode.right, targetSum - treenode.val);

    }
}
