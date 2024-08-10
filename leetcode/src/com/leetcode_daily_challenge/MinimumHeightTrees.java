package com.leetcode_daily_challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees {
    Map<Integer, List<Integer>> graph;

    private List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        graph = new HashMap<>(n);
        /*
         * Represent the edges as adjacency list to form a graph and for each node as
         * root node
         * make a n-array tree and calculate its height
         */
        for (int[] edge : edges) {
            int vertexU = edge[0];
            int vertexV = edge[1];
            graph.putIfAbsent(vertexU, new ArrayList<>());
            graph.putIfAbsent(vertexV, new ArrayList<>());
            graph.get(vertexU).add(vertexV);
            graph.get(vertexV).add(vertexU);
        }
        int minHeight = Integer.MAX_VALUE;
        List<Integer> minHeightTreesList = new ArrayList<>();
        minHeightTreesList.add(minHeight);
        for (int i = 0; i < n; i++) {
            int curHeight = getHeightOfTree(i, n);
            if (curHeight < minHeight) {
                minHeight = curHeight;
                minHeightTreesList.clear();
                minHeightTreesList.add(i);
            } else if (curHeight == minHeight) {
                minHeightTreesList.add(i);
            }
        }
        return minHeightTreesList;
    }

    private int getHeightOfTree(int root, int totalNodes) {
        int height = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[totalNodes];
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            while (size-- > 0) {
                int curNode = queue.poll();
                visited[curNode] = true;
                for (int children : graph.get(curNode)) {
                    if (!visited[children]) {
                        queue.add(children);
                    }
                }
            }
        }
        return height;
    }

    private List<Integer> findMinHeightTreesApproachTwo(int n, int[][] edges) {
        // edge cases
        if (n < 2) {
            return Arrays.asList(0);
        }
        // Build graph with adjacency list
        ArrayList<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        // Initialize the first layer of leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (neighbors.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        // Trim the leaves until we reach centroids, for odd number of nodes there is
        // only centroid
        // for even number of nodes, there are two centroids
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            // remove the current leaves along with edges
            for (Integer leaf : leaves) {
                Integer neighbor = neighbors.get(leaf).iterator().next();
                // remove edge along with the node
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        minimumHeightTrees.findMinHeightTrees(0, null);
        minimumHeightTrees.findMinHeightTreesApproachTwo(0, null);
    }
}
