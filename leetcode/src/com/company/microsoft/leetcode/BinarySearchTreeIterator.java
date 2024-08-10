package com.company.microsoft.leetcode;

import java.util.ArrayDeque;

import com.leetcode_daily_challenge.TreeNode;

public class BinarySearchTreeIterator {
    ArrayDeque<TreeNode> stack;
    TreeNode node;

    private BinarySearchTreeIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        node = root;
    }

    private int next() {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int res = node.val;
        node = node.right;
        return res;
    }

    private boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }

    public static void main(String[] args) {
        BinarySearchTreeIterator binarySearchTreeIterator = new BinarySearchTreeIterator(null);
        binarySearchTreeIterator.hasNext();
        binarySearchTreeIterator.next();
    }
}
