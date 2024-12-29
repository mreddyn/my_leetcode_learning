package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class ShortestDistanceAfterRoadAdditionQueriesOne {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int totalQueries = queries.length;
        var res = new int[totalQueries];
        var adjList = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < n - 1; i++) {
            adjList.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
        }

        int resIndex = 0;
        for (var query : queries) {
            int u = query[0];
            int v = query[1];
            adjList.get(u).add(v);
            res[resIndex++] = findShortestPath(adjList, 0, n - 1, n);
        }

        return res;
    }

    private int findShortestPath(HashMap<Integer, ArrayList<Integer>> adjList, int start, int end, int n) {
        // will do bfs to find shortest path between start and end
        int res = 0;
        var visited = new boolean[n];
        var queue = new ArrayDeque<Integer>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                visited[cur] = true;
                if (cur == end) {
                    return res;
                }

                // visit the connections
                for (var next : adjList.get(cur)) {
                    if (!visited[next]) {
                        queue.offer(next);
                    }
                }
            }
            res++;
        }

        return res;
    }
}
