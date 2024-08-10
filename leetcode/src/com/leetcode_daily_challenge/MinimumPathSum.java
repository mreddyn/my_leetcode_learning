package com.leetcode_daily_challenge;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int rows;
        int columns;
        int runningSum;
        rows = grid.length;
        columns = grid[0].length;
        runningSum = 0;
        for (int row = 0; row < rows; row++) {
            grid[row][0] += runningSum;
            runningSum = grid[row][0];
        }

        runningSum = 0;
        for (int col = 0; col < columns; col++) {
            grid[0][col] += runningSum;
            runningSum = grid[0][col];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < columns; col++) {
                grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        return grid[rows - 1][columns - 1];
    }
}
