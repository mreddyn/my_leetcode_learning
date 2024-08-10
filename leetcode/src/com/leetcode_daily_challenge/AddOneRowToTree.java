package com.leetcode_daily_challenge;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
    private TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode newNode = new TreeNode(val);
        if (depth == 1) {
            newNode.left = root.left;
            newNode.right = root.right;
            return newNode;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        boolean isOneRowAdded = false;
        queue.offer(root);
        while (!isOneRowAdded && !queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (level == depth - 1) {
                    TreeNode newNodeOne = new TreeNode(val);
                    newNodeOne.left = cur.left;
                    cur.left = newNodeOne;
                    TreeNode newNodeTwo = new TreeNode(val);
                    newNodeTwo.right = cur.right;
                    cur.right = newNodeTwo;
                    isOneRowAdded = true;

                } else {
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
            level++;
        }
        return root;
    }

    public static void main(String[] args) {
        AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
        addOneRowToTree.addOneRow(null, 0, 0);
    }
}
