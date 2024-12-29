package com.leetcode.medium;

public class CountUnGuardedCellsInGrid {
    private final int UNGUARDED = 0;
    private final int GUARDED = 1;
    private final int GUARD = 2;
    private final int WALL = 3;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int unguardedCount = 0;
        var grid = new int[m][n];
        // init guards
        for (var guard : guards) {
            grid[guard[0]][guard[1]] = GUARD;
        }

        // init walls
        for (var wall : walls) {
            grid[wall[0]][wall[1]] = WALL;
        }

        // now mark cells as guarded from each guard
        for (var guard : guards) {
            markGuarded(guard[0], guard[1], m, n, grid);
        }

        // count the unguarded cells
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == UNGUARDED) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }

    private void markGuarded(int row, int col, int m, int n, int[][] grid) {
        // travel upwards
        for (int r = row - 1; r >= 0; r--) {
            if (grid[r][col] == WALL || grid[r][col] == GUARD) {
                break;
            }
            grid[r][col] = GUARDED;
        }

        // travel down
        for (int r = row + 1; r < m; r++) {
            if (grid[r][col] == WALL || grid[r][col] == GUARD) {
                break;
            }
            grid[r][col] = GUARDED;
        }

        // travel right
        for (int c = col + 1; c < n; c++) {
            if (grid[row][c] == WALL || grid[row][c] == GUARD) {
                break;
            }
            grid[row][c] = GUARDED;
        }

        // travel left
        for (int c = col - 1; c >= 0; c--) {
            if (grid[row][c] == WALL || grid[row][c] == GUARD) {
                break;
            }
            grid[row][c] = GUARDED;
        }
    }

}
