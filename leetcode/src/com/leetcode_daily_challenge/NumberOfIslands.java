package com.leetcode_daily_challenge;

import java.util.ArrayDeque;

public class NumberOfIslands {
    private int numIslands(char[][] grid) {
        int totalIslands = 0, rows = grid.length, cols = grid[0].length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    queue.add(new int[] { row, col });
                    totalIslands++;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size-- > 0) {
                            int[] cur = queue.poll();
                            int r = cur[0];
                            int c = cur[1];
                            grid[r][c] = '0';
                            if (r > 0 && grid[r - 1][c] == '1') {
                                queue.add(new int[] { r - 1, c });
                            }
                            if (r + 1 < rows && grid[r + 1][c] == '1') {
                                queue.add(new int[] { r + 1, c });
                            }
                            if (c > 0 && grid[r][c - 1] == '1') {
                                queue.add(new int[] { r, c - 1 });
                            }
                            if (c + 1 < cols && grid[r][c + 1] == '1') {
                                queue.add(new int[] { r, c + 1 });
                            }
                        }
                    }
                }
            }
        }
        return totalIslands;
    }

    private int numIslandsApproachTwo(char[][] grid) {
        int totalIslands = 0, rows = grid.length, cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    totalIslands++;
                    dfs(grid, row, col, rows, cols);
                }
            }
        }
        return totalIslands;
    }

    private void dfs(char[][] grid, int row, int col, int rows, int cols) {
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        if (row > 0) {
            dfs(grid, row - 1, col, rows, cols);
        }
        if (col > 0) {
            dfs(grid, row, col - 1, rows, cols);
        }
        if (row + 1 < rows) {
            dfs(grid, row + 1, col, rows, cols);
        }
        if (col + 1 < cols) {
            dfs(grid, row, col + 1, rows, cols);
        }
        return;
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        numberOfIslands.numIslands(null);
        numberOfIslands.numIslandsApproachTwo(null);
    }
}
