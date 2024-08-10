package com.leetcode_daily_challenge;

public class IslandPerimeter {
    private int islandPerimeter(int[][] grid) {
        int perimeter = 0, rows = grid.length, cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    if (row == 0 || grid[row - 1][col] == 0) {
                        perimeter++;
                    }
                    if (row == rows - 1 || grid[row + 1][col] == 0) {
                        perimeter++;
                    }
                    if (col == 0 || grid[row][col - 1] == 0) {
                        perimeter++;
                    }
                    if (col == cols - 1 || grid[row][col + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 1 } };
        System.out.println(islandPerimeter.islandPerimeter(grid));
    }
}
