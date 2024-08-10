package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        long maxImportance = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // create the graph and insert the edges respectively
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Comparator<int[]> customComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        };

        // Insert into priority queue to sort them based on the neighbor cities size,
        // if neighbors are equal then sort them based on lowest number
        PriorityQueue<int[]> pq = new PriorityQueue<>(customComparator);
        for (int key : graph.keySet()) {
            int size = graph.get(key).size();
            pq.add(new int[] { key, size });
        }

        int priority = 1;
        Map<Integer, Integer> cityPriorityMap = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            cityPriorityMap.put(cur[0], priority++);
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            maxImportance += cityPriorityMap.get(u) + cityPriorityMap.get(v);
        }

        return maxImportance;
    }

    public static void main(String[] args) {
        MaximumTotalImportanceOfRoads mRoads = new MaximumTotalImportanceOfRoads();
        System.out.println(mRoads.maximumImportance(5, new int[][] { { 0, 1 } }));
    }
}
