package com.leetcode_daily_challenge;

public class FindValidMatrixGivenRowAndColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length, cols = colSum.length;
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Math.min(rowSum[row], colSum[col]);

                rowSum[row] -= matrix[row][col];
                colSum[col] -= matrix[row][col];
            }
        }

        return matrix;
    }
}
