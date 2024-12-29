package com.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomOne {
    private final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length, cols = moveTime[0].length;
        var pQueue = new PriorityQueue<int[]>((a, b) -> (a[2] - b[2]));
        // maintain a 2d array to keep track of minimum time to reach that cell
        var time = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            Arrays.fill(time[row], Integer.MAX_VALUE);
        }

        pQueue.offer(new int[] { 0, 0, moveTime[0][0] });
        time[0][0] = moveTime[0][0];

        while (!pQueue.isEmpty()) {
            int size = pQueue.size();
            while (size-- > 0) {
                var cur = pQueue.poll();
                int row = cur[0];
                int col = cur[1];
                int currentTime = cur[2];

                if (row == rows - 1 && col == cols - 1) {
                    // we have reached bottom-right cell
                    return currentTime;
                }

                // explore all directions
                for (var direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (isValid(newRow, newCol, rows, cols)) {
                        int waitTime = Math.max(moveTime[newRow][newCol] - currentTime, 0);
                        int newTime = currentTime + 1 + waitTime;
                        if (newTime < time[newRow][newCol]) {
                            time[newRow][newCol] = newTime;
                            pQueue.offer(new int[] { newRow, newCol, newTime });
                        }
                    }

                }
            }
        }

        return -1; // unreachable
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        if (row >= 0 && col >= 0 && row < rows && col < cols) {
            return true;
        }
        return false;
    }
}
