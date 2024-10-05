package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.leetcode_daily_challenge.TreeNode;

public class KthSmallestInaBST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = inOrder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    private List<Integer> inOrder(TreeNode root, ArrayList<Integer> inOrderList) {
        if (root == null) {
            return inOrderList;
        }

        inOrder(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrder(root.right, inOrderList);
        return inOrderList;
    }

    public int kthSmallestIterativeDFS(TreeNode root, int k) {
        var stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }

        return -1;
    }
}
