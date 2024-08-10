package com.leetcode_daily_challenge;

public class MaximumDifferenceBetweenNodeAndAncestor {
    private int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDiff[] = new int[1];
        dfs(root, root.val, root.val, maxDiff);
        return maxDiff[0];
    }

    private void dfs(TreeNode root, int min, int max, int maxDiff[]) {
        if (root == null) {
            return;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        maxDiff[0] = Math.max(maxDiff[0], Math.abs(max - min));
        dfs(root.left, min, max, maxDiff);
        dfs(root.right, min, max, maxDiff);
    }

    public static void main(String[] args) {
        MaximumDifferenceBetweenNodeAndAncestor solution = new MaximumDifferenceBetweenNodeAndAncestor();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println(solution.maxAncestorDiff(root));
    }
}
