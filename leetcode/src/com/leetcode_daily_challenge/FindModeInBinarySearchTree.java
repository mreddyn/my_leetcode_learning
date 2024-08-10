package com.leetcode_daily_challenge;

import java.util.List;

public class FindModeInBinarySearchTree {
    private int[] findMode(TreeNode root) {
        List<Integer> list = new java.util.ArrayList<>();
        inOrder(root, list);
        List<Integer> result = new java.util.ArrayList<>();
        int currNum = list.get(0);
        int currCount = 0;
        int maxCount = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == currNum) {
                currCount++;
            } else {
                currNum = list.get(i);
                currCount = 1;
            }
            if (currCount > maxCount) {
                maxCount = currCount;
                result.clear();
            }
            if (currCount == maxCount) {
                result.add(currNum);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static void main(String[] args) {
        FindModeInBinarySearchTree findModeInBinarySearchTree = new FindModeInBinarySearchTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        int[] result = findModeInBinarySearchTree.findMode(root);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
