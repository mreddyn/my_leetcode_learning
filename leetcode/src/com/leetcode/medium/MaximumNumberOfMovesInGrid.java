package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaximumNumberOfMovesInGrid {
    public int maxMoves(int[][] grid) {
        int maximumMoves = 0, rows = grid.length, cols = grid[0].length;
        // we wil do a BFS for every cell in the first column
        var queue = new ArrayDeque<int[]>();

        // HashSet to keep track of visited
        var visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            queue.offer(new int[] { row, 0 });
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            maximumMoves++;
            while (size-- > 0) {
                var cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                // travel diagonal up direction
                if (row - 1 >= 0 && col + 1 < cols && grid[row][col] < grid[row - 1][col + 1]
                        && !visited[row - 1][col + 1]) {
                    queue.offer(new int[] { row - 1, col + 1 });
                    visited[row - 1][col + 1] = true;
                }

                // travel right direction
                if (col + 1 < cols && grid[row][col] < grid[row][col + 1] && !visited[row][col + 1]) {
                    queue.offer(new int[] { row, col + 1 });
                    visited[row][col + 1] = true;
                }

                // travel diagonal down direction
                if (row + 1 < rows && col + 1 < cols && grid[row][col] < grid[row + 1][col + 1]
                        && !visited[row + 1][col + 1]) {
                    queue.offer(new int[] { row + 1, col + 1 });
                    visited[row + 1][col + 1] = true;
                }
            }
        }

        return maximumMoves - 1;
    }

    private final int[] directions = { -1, 0, 1 };

    public int maxMovesApproachTwo(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] dp = new int[M][N];

        // fill the dp with -1
        for (int row = 0; row < M; row++) {
            Arrays.fill(dp[row], -1);
        }

        int maxMoves = 0;
        for (int row = 0; row < M; row++) {
            int movesRequired = dfs(row, 0, grid, dp);
            maxMoves = Math.max(maxMoves, movesRequired);
        }

        return maxMoves;
    }

    private int dfs(int row, int col, int[][] grid, int[][] dp) {
        int M = grid.length, N = grid[0].length;

        // if we already calculated the moves for this cell, then return
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int maxMoves = 0;
        for (int dir : directions) {
            int newRow = row + dir;
            int newCol = col + 1;
            // if next cell is valid and greater than the current cell value
            // then do recursion

            if (newRow >= 0 && newCol >= 0 && newRow < M && newCol < N && grid[row][col] < grid[newRow][newCol]) {
                maxMoves = Math.max(maxMoves, 1 + dfs(newRow, newCol, grid, dp));
            }
        }

        dp[row][col] = maxMoves;
        return maxMoves;

    }

    public static void main(String[] args) {
        MaximumNumberOfMovesInGrid movesInGrid = new MaximumNumberOfMovesInGrid();
        System.out.println(movesInGrid.maxMoves(new int[][] { { 137, 112, 78, 67 }, { 76, 65, 122, 135 } }));
    }
}
