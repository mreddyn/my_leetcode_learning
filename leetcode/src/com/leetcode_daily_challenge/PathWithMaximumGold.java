package com.leetcode_daily_challenge;

public class PathWithMaximumGold {

    private int getMaximumGold(int[][] grid) {
        int maxGold = 0, rows = grid.length, cols = grid[0].length, curGold = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0) {
                    curGold = dfs(grid, row, col, rows, cols);
                    maxGold = Math.max(maxGold, curGold);
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int row, int col, int rows, int cols) {
        if (grid[row][col] == 0) {
            return 0;
        }
        int up = 0, left = 0, right = 0, down = 0;
        int temp = grid[row][col];
        grid[row][col] = 0;
        if (row + 1 < rows) {
            down = dfs(grid, row + 1, col, rows, cols);
        }
        if (col + 1 < cols) {
            right = dfs(grid, row, col + 1, rows, cols);
        }
        if (row - 1 >= 0) {
            up = dfs(grid, row - 1, col, rows, cols);
        }
        if (col - 1 >= 0) {
            left = dfs(grid, row, col - 1, rows, cols);
        }
        grid[row][col] = temp;
        int curGold = Math.max(up, Math.max(down, Math.max(left, right)));
        return curGold + temp;
    }

    public static void main(String[] args) {
        PathWithMaximumGold pMaximumGold = new PathWithMaximumGold();
        System.out.println(pMaximumGold.getMaximumGold(new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } }));
    }
}
