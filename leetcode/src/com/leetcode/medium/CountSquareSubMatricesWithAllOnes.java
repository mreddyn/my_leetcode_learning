package com.leetcode.medium;

public class CountSquareSubMatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        /*
         * dp[i][j] means the size of biggest square with A[i][j] as bottom-right
         * corner.
         * dp[i][j] also means the number of squares with A[i][j] as bottom-right
         * corner.
         * 
         * If A[i][j] == 0, no possible square.
         * If A[i][j] == 1,
         * we compare the size of square dp[i-1][j-1], dp[i-1][j] and dp[i][j-1].
         * min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1 is the maximum size of square
         * that we can find.
         */
        int rows = matrix.length, cols = matrix[0].length, totalSquares = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] > 0 && row > 0 && col > 0) {
                    matrix[row][col] = Math.min(matrix[row - 1][col - 1],
                            Math.min(matrix[row - 1][col], matrix[row][col - 1])) + 1;
                }
                totalSquares += matrix[row][col];
            }
        }

        return totalSquares;
    }
}
