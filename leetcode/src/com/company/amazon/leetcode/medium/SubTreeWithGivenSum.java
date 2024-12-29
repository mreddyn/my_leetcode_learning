package com.company.amazon.leetcode.medium;

import com.leetcode_daily_challenge.TreeNode;

public class SubTreeWithGivenSum {
    public boolean hasSubTreeWithGivenSum(TreeNode root, int target) {
        boolean[] foundSum = new boolean[] { false };
        subTreeSum(root, foundSum, target);
        return foundSum[0];
    }

    private int subTreeSum(TreeNode root, boolean[] foundSum, int target) {
        if (root == null) {
            return 0;
        }

        int leftSubTreeSum = subTreeSum(root.left, foundSum, target);
        int rightSubTreeSum = subTreeSum(root.right, foundSum, target);
        int currentSum = root.val + leftSubTreeSum + rightSubTreeSum;

        if (currentSum == target) {
            foundSum[0] = true;
        }

        return currentSum;
    }
}
