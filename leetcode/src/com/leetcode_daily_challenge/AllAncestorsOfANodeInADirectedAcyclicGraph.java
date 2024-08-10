package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        /*
         * Reverse the graph and do BFS/DFS traversal from node to find all its
         * ancestors
         */
        List<List<Integer>> ancestorsList = new ArrayList<>();
        adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList.putIfAbsent(to, new ArrayList<>());
            adjacencyList.get(to).add(from);
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            List<Integer> ancestors = new ArrayList<>();
            findChildren(i, visited);
            System.out.println(visited);
            for (int node = 0; node < n; node++) {
                if (node == i) {
                    continue;
                }
                if (visited.contains(node)) {
                    ancestors.add(node);
                }
            }
            ancestorsList.add(ancestors);
        }

        return ancestorsList;
    }

    private void findChildren(int currentNode, Set<Integer> visitedNodes) {
        visitedNodes.add(currentNode);
        // recursively traverse all neighbors
        for (int neighbor : adjacencyList.getOrDefault(currentNode, new ArrayList<>())) {
            if (!visitedNodes.contains(neighbor)) {
                findChildren(neighbor, visitedNodes);
            }
        }
    }
}
