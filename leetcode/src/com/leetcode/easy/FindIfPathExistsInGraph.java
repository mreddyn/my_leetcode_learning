package com.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        var graph = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }

        // queue for BFS
        var queue = new ArrayDeque<Integer>();
        queue.offer(source);
        var visited = new boolean[n];

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == destination) {
                return true;
            }
            if (visited[cur]) {
                continue;
            }

            visited[cur] = true;
            for (int neighbor : graph.get(cur)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }
}
