package com.company.facebook.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.leetcode_daily_challenge.TreeNode;

public class VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        /*
         * start with the rootNode with indexSum of 0.
         * Do a level order traversal, when visiting a node, add its value to the
         * corresponding indexSum in Hashmap.
         * if left node exists then pass indexSum as indexSum-1
         * if right node exists then pass indexSum as indexSum+1
         * 
         * 
         */
        int minIndex = Integer.MAX_VALUE, maxIndex = Integer.MIN_VALUE;
        var map = new HashMap<Integer, List<Integer>>();
        var queue = new ArrayDeque<Node>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            var tempMap = new HashMap<Integer, ArrayList<Integer>>();
            while (size-- > 0) {
                Node curNode = queue.poll();
                var curTreeNode = curNode.treeNode;
                int index = curNode.indexSum;
                minIndex = Math.min(minIndex, index);
                maxIndex = Math.max(maxIndex, index);
                tempMap.computeIfAbsent(index, k -> new ArrayList<>()).add(curTreeNode.val);

                if (curTreeNode.left != null) {
                    queue.offer(new Node(curTreeNode.left, index - 1));
                }

                if (curTreeNode.right != null) {
                    queue.offer(new Node(curTreeNode.right, index + 1));
                }
            }

            for (int key : tempMap.keySet()) {
                var list = tempMap.get(key);
                Collections.sort(list);
                map.computeIfAbsent(key, k -> new ArrayList<>()).addAll(list);
            }
        }

        for (int i = minIndex; i <= maxIndex; i++) {
            var list = map.get(i);
            res.add(list);
        }

        return res;
    }

    record Node(TreeNode treeNode, int indexSum) {
    };
}
