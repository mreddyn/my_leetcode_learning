package com.leetcode_daily_challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class AmountOfTimeForBinaryTreeInfected {
    private int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (!graph.containsKey(node.val)) {
                    graph.put(node.val, new java.util.ArrayList<>());
                }
                if (node.left != null) {
                    graph.get(node.val).add(node.left.val);
                    queue.add(node.left);
                    if (!graph.containsKey(node.left.val)) {
                        graph.put(node.left.val, new java.util.ArrayList<>());
                    }
                    graph.get(node.left.val).add(node.val);
                }
                if (node.right != null) {
                    graph.get(node.val).add(node.right.val);
                    queue.add(node.right);
                    if (!graph.containsKey(node.right.val)) {
                        graph.put(node.right.val, new java.util.ArrayList<>());
                    }
                    graph.get(node.right.val).add(node.val);
                }
            }
        }
        System.out.println(graph);
        HashSet<Integer> visited = new HashSet<>();
        int[] time = new int[1];
        bfs(graph, start, visited, time);
        return time[0] - 1; // -1 because we don't count the start node
    }

    private void bfs(HashMap<Integer, List<Integer>> graph, int start, HashSet<Integer> visited, int[] time) {

        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            time[0]++;
            while (size-- > 0) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        AmountOfTimeForBinaryTreeInfected a = new AmountOfTimeForBinaryTreeInfected();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(a.amountOfTime(root, 3));
    }
}
