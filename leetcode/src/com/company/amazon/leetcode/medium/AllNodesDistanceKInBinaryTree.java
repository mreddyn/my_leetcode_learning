package com.company.amazon.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.leetcode_daily_challenge.TreeNode;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        var res = new ArrayList<Integer>();
        // Build the graph <child node, parent node>
        var graph = new HashMap<TreeNode, TreeNode>();
        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    graph.put(node.left, node);
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    graph.put(node.right, node);
                    queue.offer(node.right);
                }

            }
        }

        // now when k == 0 we can add all the nodes in the queue to res
        queue.clear();
        queue.offer(target);
        var visited = new HashSet<TreeNode>();
        visited.add(target);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (depth == k) {
                break;
            }
            while (size-- > 0) {
                TreeNode node = queue.poll();
                // travel one level (left, right, and parent)
                if (node.left != null && visited.add(node.left)) {
                    queue.offer(node.left);
                }

                if (node.right != null && visited.add(node.right)) {
                    queue.offer(node.right);
                }

                if (graph.get(node) != null && visited.add(graph.get(node))) {
                    queue.offer(graph.get(node));
                }
            }
            depth++;
        }

        // now we can add all the nodes from queue to res which are at k distance
        while (!queue.isEmpty()) {
            res.add(queue.poll().val);
        }

        return res;
    }
}
