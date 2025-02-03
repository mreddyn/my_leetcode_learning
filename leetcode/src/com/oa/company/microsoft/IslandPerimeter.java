package com.oa.company.microsoft;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int perimeter = 0;
        int up, down, left, right;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    if (row == 0) {
                        up = 0;
                    } else {
                        up = grid[row - 1][col];
                    }

                    if (col == 0) {
                        left = 0;
                    } else {
                        left = grid[row][col - 1];
                    }

                    if (row == rows - 1) {
                        down = 0;
                    } else {
                        down = grid[row + 1][col];
                    }

                    if (col == cols - 1) {
                        right = 0;
                    } else {
                        right = grid[row][col + 1];
                    }

                    perimeter += (4 - (left + right + up + down));
                }
            }
        }

        return perimeter;
    }
}
