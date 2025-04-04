package com.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    private final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;

        // to store the max absolute distance
        var distance = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            Arrays.fill(distance[row], Integer.MAX_VALUE);
        }

        var visited = new boolean[rows][cols];

        // for BFS we will use PriorityQueue to traverse min difference first.
        var minHeap = new PriorityQueue<int[]>((a, b) -> (a[2] - b[2])); // row, col, distance
        minHeap.offer(new int[] { 0, 0, 0 });
        distance[0][0] = 0;

        while (!minHeap.isEmpty()) {
            int size = minHeap.size();
            while (size-- > 0) {
                var cur = minHeap.poll();
                int row = cur[0];
                int col = cur[1];
                int dist = cur[2];
                visited[row][col] = true;

                // check if we reached bottom right cell
                if (row == rows - 1 && col == cols - 1) {
                    return dist;
                }

                for (var direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (isValid(newRow, newCol, rows, cols) && !visited[newRow][newCol]) {
                        int newDist = Math.max(dist, Math.abs(heights[row][col] - heights[newRow][newCol]));
                        if (distance[newRow][newCol] > newDist) {
                            distance[newRow][newCol] = newDist;
                            minHeap.offer(new int[] { newRow, newCol, newDist });
                        }
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        if (row >= 0 && col >= 0 && row < rows && col < cols) {
            return true;
        }
        return false;
    }
}
