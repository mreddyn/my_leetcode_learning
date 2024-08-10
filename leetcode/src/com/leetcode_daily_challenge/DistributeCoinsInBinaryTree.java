package com.leetcode_daily_challenge;

public class DistributeCoinsInBinaryTree {
    int moves;

    private int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftCoins = dfs(node.left);
        int rightCoins = dfs(node.right);

        moves += Math.abs(leftCoins) + Math.abs(rightCoins);

        return (node.val - 1) + leftCoins + rightCoins;
    }

    public static void main(String[] args) {
        DistributeCoinsInBinaryTree dInBinaryTree = new DistributeCoinsInBinaryTree();
        dInBinaryTree.distributeCoins(null);
    }
}
