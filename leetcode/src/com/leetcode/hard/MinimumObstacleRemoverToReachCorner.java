package com.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumObstacleRemoverToReachCorner {
    private final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumObstacles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        // this minObstacles represents unvisited cells and updates if a cell can be
        // visited with less cost
        var minObstacles = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            Arrays.fill(minObstacles[row], Integer.MAX_VALUE);
        }

        minObstacles[0][0] = grid[0][0];

        var pQueue = new PriorityQueue<int[]>((a, b) -> (a[2] - b[2]));
        // add the starting cell for BFS traversal
        pQueue.offer(new int[] { 0, 0, grid[0][0] });

        while (!pQueue.isEmpty()) {
            int size = pQueue.size();
            // visit all neighbor cells at this level
            while (size-- > 0) {
                var cur = pQueue.poll();
                int row = cur[0];
                int col = cur[1];
                int obstacles = cur[2];

                if (row == rows - 1 && col == cols - 1) {
                    // we have reached bottom-right corner
                    return obstacles;
                }

                // explore all directions (up, down, right, left)
                for (var direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (isValid(newRow, newCol, rows, cols)) {
                        int newObstacles = obstacles + grid[newRow][newCol];

                        // if we find a path with fewer obstacles we update it
                        if (newObstacles < minObstacles[newRow][newCol]) {
                            minObstacles[newRow][newCol] = newObstacles;
                            pQueue.offer(new int[] { newRow, newCol, newObstacles });
                        }

                    }
                }
            }
        }

        return minObstacles[rows - 1][cols - 1];
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        if (row >= 0 && col >= 0 && row < rows && col < cols) {
            return true;
        }
        return false;
    }

    public int minimumObstaclesApproachTwo(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        var minObstacles = new int[rows][cols];

        // initialize with Max_VALUE
        for (var minObstacle : minObstacles) {
            Arrays.fill(minObstacle, Integer.MAX_VALUE);
        }

        minObstacles[0][0] = grid[0][0];

        // store cell with obstacleCount to reach this cell
        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { 0, 0, grid[0][0] });

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                var cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                int obstacles = cur[2];

                // if we reached bottom-right cell
                if (row == rows - 1 && col == cols - 1) {
                    return minObstacles[row][col];
                }

                // explore all directions
                for (var direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (isValid(newRow, newCol, rows, cols) && minObstacles[newRow][newCol] == Integer.MAX_VALUE) {

                        // now we check for the neighbor cell is a obstacle or not
                        // if it is a obstacle then we push it to end of queue
                        // else we push it to front of the queue
                        if (grid[newRow][newCol] == 1) {
                            minObstacles[newRow][newCol] = obstacles + 1;
                            queue.offerLast(new int[] { newRow, newCol, obstacles + 1 });
                        } else {
                            minObstacles[newRow][newCol] = obstacles;
                            queue.offerFirst(new int[] { newRow, newCol, obstacles });
                        }
                    }
                }

            }
        }

        return minObstacles[rows - 1][cols - 1];
    }
}
