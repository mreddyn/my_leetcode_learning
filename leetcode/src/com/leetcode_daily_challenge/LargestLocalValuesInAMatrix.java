package com.leetcode_daily_challenge;

public class LargestLocalValuesInAMatrix {
    private int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];
        for (int row = 0; row < n - 2; row++) {
            for (int col = 0; col < n - 2; col++) {
                maxLocal[row][col] = findMax(grid, row, col);
            }
        }
        return maxLocal;
    }

    private int findMax(int[][] grid, int x, int y) {
        int maxElement = 0;
        for (int row = x; row < x + 3; row++) {
            for (int col = y; col < y + 3; col++) {
                maxElement = Math.max(maxElement, grid[row][col]);
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {
        LargestLocalValuesInAMatrix lInAMatrix = new LargestLocalValuesInAMatrix();
        lInAMatrix.largestLocal(new int[][] {});
    }
}
