package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestoreTheArrayFromAdjacentPairs {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    private int[] restoreArray(int[][] adjacentPairs) {
        int[] result = new int[adjacentPairs.length + 1];
        for (int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int root = 0;
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                root = key;
                break;
            }
        }
        dfs(root, -1, result, 0);
        return result;
    }

    private void dfs(int node, int prev, int[] result, int index) {
        result[index] = node;
        index++;
        for (int neighbor : graph.get(node)) {
            if (neighbor != prev) {
                dfs(neighbor, node, result, index);
            }
        }
    }

    public static void main(String[] args) {
        RestoreTheArrayFromAdjacentPairs rt = new RestoreTheArrayFromAdjacentPairs();
        int[][] adjacentPairs = { { 2, 1 }, { 3, 4 }, { 3, 2 } };
        int[] result = rt.restoreArray(adjacentPairs);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
