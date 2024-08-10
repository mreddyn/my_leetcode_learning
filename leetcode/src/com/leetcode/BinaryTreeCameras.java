package com.leetcode;

import com.leetcode_daily_challenge.TreeNode;

public class BinaryTreeCameras {
    int cameras;

    private int minCameraCover(TreeNode root) {
        cameras = 0;
        return (dfs(root) < 1 ? 1 : 0) + cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 2;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == 0 && right == 0) {
            cameras++;
            return 1;
        }
        return (left == 1 || right == 1) ? 2 : 0;
    }

    public static void main(String[] args) {
        BinaryTreeCameras binaryTreeCameras = new BinaryTreeCameras();
        binaryTreeCameras.minCameraCover(null);
    }
}
