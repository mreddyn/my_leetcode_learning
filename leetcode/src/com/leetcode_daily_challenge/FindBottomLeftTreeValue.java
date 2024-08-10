package com.leetcode_daily_challenge;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    private int findBottomLeftValue(TreeNode root) {
        int bottomLeftValue = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                bottomLeftValue = cur.val;
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }

            }
        }
        return bottomLeftValue;
    }

    public static void main(String[] args) {
        FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
        TreeNode root = new TreeNode(1);
        findBottomLeftTreeValue.findBottomLeftValue(root);
    }
}
