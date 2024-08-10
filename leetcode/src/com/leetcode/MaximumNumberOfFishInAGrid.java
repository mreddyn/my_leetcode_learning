package com.leetcode;

public class MaximumNumberOfFishInAGrid {
    private int findMaxFish(int[][] grid) {
        int maxFishGrid = 0, rows = grid.length, cols = grid[0].length;
        int[] curFishGrid = new int[1];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] > 0) {
                    curFishGrid[0] = 0;
                    dfs(grid, row, col, rows, cols, curFishGrid);
                    maxFishGrid = Math.max(maxFishGrid, curFishGrid[0]);
                }
            }
        }
        return maxFishGrid;
    }

    private void dfs(int[][] grid, int row, int col, int rows, int cols, int[] curFishGrid) {
        if (grid[row][col] == 0) {
            return;
        }
        curFishGrid[0] += grid[row][col];
        grid[row][col] = 0;
        if (row > 0) {
            dfs(grid, row - 1, col, rows, cols, curFishGrid);
        }
        if (col > 0) {
            dfs(grid, row, col - 1, rows, cols, curFishGrid);
        }
        if (row + 1 < rows) {
            dfs(grid, row + 1, col, rows, cols, curFishGrid);
        }
        if (col + 1 < cols) {
            dfs(grid, row, col + 1, rows, cols, curFishGrid);
        }
        return;
    }

    public static void main(String[] args) {
        MaximumNumberOfFishInAGrid maximumNumberOfFishInAGrid = new MaximumNumberOfFishInAGrid();
        maximumNumberOfFishInAGrid.findMaxFish(null);
    }
}
