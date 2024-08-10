package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindTheCityWithSmallestNumberOfNeighbors {
    private HashMap<Integer, List<Pair>> adjacencyList;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int distance = edge[2];
            adjacencyList.putIfAbsent(u, new ArrayList<>());
            adjacencyList.putIfAbsent(v, new ArrayList<>());
            adjacencyList.get(u).add(new Pair(v, distance));
            adjacencyList.get(v).add(new Pair(u, distance));
        }

        return 0;
    }

    class Pair {
        int city;
        int distance;

        Pair(int city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }
}
