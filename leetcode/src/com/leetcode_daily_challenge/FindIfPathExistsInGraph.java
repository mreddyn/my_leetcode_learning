package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIfPathExistsInGraph {
    Map<Integer, List<Integer>> graph;

    private boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = new HashMap<>();
        for (int[] edge : edges) {
            int vertexU = edge[0];
            int vertexV = edge[1];
            graph.putIfAbsent(vertexU, new ArrayList<>());
            graph.putIfAbsent(vertexV, new ArrayList<>());
            graph.get(vertexU).add(vertexV);
            graph.get(vertexV).add(vertexU);
        }
        for (int key : graph.keySet()) {
            System.out.println(graph.get(key));
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, visited);
    }

    private boolean dfs(int neighbor, int destination, boolean[] visited) {
        if (neighbor == destination) {
            return true;
        }
        if (!visited[neighbor]) {
            visited[neighbor] = true;
            for (int key : graph.get(neighbor)) {
                if (dfs(key, destination, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindIfPathExistsInGraph findIfPathExistsInGraph = new FindIfPathExistsInGraph();
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };
        int n = 6;
        int source = 0;
        int destination = 6;
        findIfPathExistsInGraph.validPath(n, edges, source, destination);
    }
}
