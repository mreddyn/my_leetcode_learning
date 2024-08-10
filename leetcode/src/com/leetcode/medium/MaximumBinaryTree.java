package com.leetcode.medium;

import com.leetcode_daily_challenge.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = constructTree(nums, 0, nums.length);
        return root;
    }

    private TreeNode constructTree(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int maxVal = Integer.MIN_VALUE, maxValIndex = start;
        for (int i = start; i < end; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
                maxValIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = constructTree(nums, start, maxValIndex);
        root.right = constructTree(nums, maxValIndex + 1, end);
        return root;
    }
}
