package com.leetcode_daily_challenge;

public class CountNodesEqualToAverageOfSubTree {
    private int averageOfSubTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int totalNodes[] = new int[] { 0 };
        helper(root, totalNodes);
        return totalNodes[0];
    }

    private int[] helper(TreeNode root, int[] totalNodes) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = helper(root.left, totalNodes);
        int[] right = helper(root.right, totalNodes);
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        int avg = Math.round(sum / count);
        if (avg == root.val) {
            totalNodes[0]++;
        }
        return new int[] { sum, count };

    }

    public static void main(String[] args) {
        CountNodesEqualToAverageOfSubTree countNodesEqualToAverageOfSubTree = new CountNodesEqualToAverageOfSubTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        int result = countNodesEqualToAverageOfSubTree.averageOfSubTree(root);
        System.out.println(result);
    }
}
