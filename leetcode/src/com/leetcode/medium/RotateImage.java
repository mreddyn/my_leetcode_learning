package com.leetcode.medium;

public class RotateImage {
    public void rotate(int[][] matrix) {
        // transpose the matrix and mirror the transposed matrix
        int n = matrix.length, temp;

        // transpose the matrix
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // mirror the transposed matrix
        for (int col = 0; col < n / 2; col++) {
            for (int row = 0; row < n; row++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[row][n - col - 1];
                matrix[row][n - col - 1] = temp;
            }
        }
    }
}
