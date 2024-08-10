package com.leetcode_daily_challenge;

public class FindCenterOfAStarGraph {
    public int findCenter(int[][] edges) {
        int centerNode = 0, totalEdges = edges.length;
        int[] graph = new int[totalEdges + 2];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u]++;
            graph[v]++;
        }

        for (int i = 1; i < graph.length; i++) {
            // if a node has n-1 edges then that node is center node
            if (graph[i] == totalEdges) {
                centerNode = i;
            }
        }

        return centerNode;
    }

    public int findCenterApproachTwo(int[][] edges) {
        // a center node must appear n-1 times i.e, it must be a common node between two
        // edges
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        return edges[0][1];
    }
}
