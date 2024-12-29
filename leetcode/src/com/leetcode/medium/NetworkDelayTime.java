package com.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int minimumTimeRequired = Integer.MAX_VALUE, rows = times.length, cols = times[0].length;

        // a 1D array to store the minimum time taken by signal to reach this node
        var nodesMinTime = new int[n];
        Arrays.fill(nodesMinTime, Integer.MAX_VALUE);

        // minHeap for BFS traversal
        var minHeap = new PriorityQueue<int[]>(); // node, time


        return minimumTimeRequired;
    }
}
