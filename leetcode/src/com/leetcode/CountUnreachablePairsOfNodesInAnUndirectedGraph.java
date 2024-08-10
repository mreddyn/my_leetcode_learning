package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    Map<Integer, List<Integer>> graph;

    private long countPairs(int n, int[][] edges) {
        /*
         * create a graph with adjacency list.
         * unreachable pairs from first component to others is number of nodes in first component*(remaining nodes)
         * remaining nodes here is total nodes - number of nodes in first component.
         * we need to calculate until all nodes are visited
         */
        graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        long unreachablePairsCount = 0, sizeOfComponent = 0, remainingNodes = n;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                sizeOfComponent = dfs(i, visited);
                unreachablePairsCount += sizeOfComponent * (remainingNodes - sizeOfComponent);
                remainingNodes -= sizeOfComponent;
            }
        }

        return unreachablePairsCount;
    }

    private int dfs(int node, boolean[] visited) {
        int count = 1;
        visited[node] = true;
        if (!graph.containsKey(node)) {
            return count;
        }
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountUnreachablePairsOfNodesInAnUndirectedGraph cGraph = new CountUnreachablePairsOfNodesInAnUndirectedGraph();
        System.out.println(cGraph.countPairs(7, new int[][] { { 0, 2 }, { 0, 5 }, { 2, 4 }, { 1, 6 }, { 5, 4 } }));
    }
}
