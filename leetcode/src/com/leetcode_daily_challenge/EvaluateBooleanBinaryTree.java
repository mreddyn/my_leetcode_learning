package com.leetcode_daily_challenge;

public class EvaluateBooleanBinaryTree {
    private boolean evaluateTree(TreeNode root) {
        if (root.val == 0) {
            return false;
        }
        if (root.val == 1) {
            return true;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if (root.val == 2) {
            return left | right;
        } else {
            return left & right;
        }
    }

    public static void main(String[] args) {
        EvaluateBooleanBinaryTree eBooleanBinaryTree = new EvaluateBooleanBinaryTree();
        eBooleanBinaryTree.evaluateTree(null);
    }
}
