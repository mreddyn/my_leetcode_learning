package com.company.microsoft.leetcode.easy;

import java.util.HashSet;

import com.leetcode_daily_challenge.TreeNode;

public class TwoSumFourInputIsaBST {
    private HashSet<Integer> seen;

    public boolean findTarget(TreeNode root, int k) {
        seen = new HashSet<>();
        return isTargetExists(root, k);
    }

    private boolean isTargetExists(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        int diff = k - root.val;
        if (seen.contains(diff)) {
            return true;
        }
        seen.add(root.val);
        return isTargetExists(root.left, k) || isTargetExists(root.right, k);
    }
}
