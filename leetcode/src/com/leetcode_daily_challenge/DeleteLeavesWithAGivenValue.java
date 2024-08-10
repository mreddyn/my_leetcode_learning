package com.leetcode_daily_challenge;

public class DeleteLeavesWithAGivenValue {
    private TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        DeleteLeavesWithAGivenValue dAGivenValue = new DeleteLeavesWithAGivenValue();
        dAGivenValue.removeLeafNodes(null, 0);
    }
}
