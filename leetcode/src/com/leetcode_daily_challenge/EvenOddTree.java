package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {
    private boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        List<Integer> nums;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            nums = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                nums.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            boolean result = helper(nums, level);
            if(!result){
                return result;
            }
            level++;

        }
        return true;
    }

    private boolean helper(List<Integer> list, int level) {
        int size = list.size();
        if (level % 2 == 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) % 2 == 0) {
                    return false;
                }
            }
            for (int i = 1; i < size; i++) {
                if (list.get(i) <= list.get(i - 1)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (list.get(i) % 2 != 0) {
                    return false;
                }
            }
            for (int i = 1; i < size; i++) {
                if (list.get(i) >= list.get(i - 1)) {
                    return false;
                }
            }

        }
        return true;
    }
}
