package com.leetcode_contest.contest_442;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PropertiesGraph {
    public int numberOfComponents(int[][] properties, int k) {
        /*
         * Convert each property-row to a set.
         * Compare every pair of sets; if their intersection size is ≥𝑘 connect them in
         * a graph.
         * Count the connected components of that graph.
         */

        int n = properties.length;
        var list = new ArrayList<HashSet<Integer>>(n);
        for (int[] property : properties) {
            var set = new HashSet<Integer>();
            for (int i : property) {
                set.add(i);
            }
            list.add(set);
        }

        var graph = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                var set1 = list.get(i);
                var set2 = list.get(j);
                if (intersect(set1, set2, k)) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        return countComponents(graph);
    }

    private boolean intersect(HashSet<Integer> set1, HashSet<Integer> set2, int k) {
        var intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection.size() >= k;
    }

    private int countComponents(HashMap<Integer, List<Integer>> graph) {
        int count = 0;
        var visited = new HashSet<Integer>();

        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, graph, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
