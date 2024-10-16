package com.leetcode.easy;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        // rotate the matrix by 90, 180, and 270.
        // check if the rotated matrix and target are equal after every rotation
        if (isMatrixEqualToTarget(mat, target)) {
            return true;
        } else if (isMatrixEqualToTarget(rotateMatrix(mat), target)) {
            return true;
        } else if (isMatrixEqualToTarget(rotateMatrix(mat), target)) {
            return true;
        } else if (isMatrixEqualToTarget(rotateMatrix(mat), target)) {
            return true;
        }
        return false;
    }

    private int[][] rotateMatrix(int[][] mat) {
        // transpose the matrix and mirror the transposed matrix
        int n = mat.length, temp;

        // transpose the matrix
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                temp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = temp;
            }
        }

        // mirror the transposed matrix
        for (int col = 0; col < n / 2; col++) {
            for (int row = 0; row < n; row++) {
                temp = mat[row][col];
                mat[row][col] = mat[row][n - col - 1];
                mat[row][n - col - 1] = temp;
            }
        }

        return mat;
    }

    private boolean isMatrixEqualToTarget(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] != target[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean findRotationApproachTwo(int[][] mat, int[][] target) {
        int n = mat.length;
        int c90 = 0, c180 = 0, c270 = 0, c360 = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (target[row][col] == mat[n - 1 - col][row]) {
                    c90++;
                }
                if (target[row][col] == mat[n - 1 - row][n - 1 - col]) {
                    c180++;
                }
                if (target[row][col] == mat[col][n - 1 - row]) {
                    c270++;
                }
                if (target[row][col] == mat[row][col]) {
                    c360++;
                }
            }
        }

        if (c90 == n * n || c180 == n * n || c270 == n * n || c360 == n * n) {
            return true;
        }

        return false;
    }
}
