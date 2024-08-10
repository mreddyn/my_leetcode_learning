package com.company.microsoft.leetcode.medium;

public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        int[][] spiralMatrix = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1, num = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse right
            for (int col = colBegin; col <= colEnd; col++) {
                spiralMatrix[rowBegin][col] = num++;
            }
            rowBegin++;

            // traverse down
            for (int row = rowBegin; row <= rowEnd; row++) {
                spiralMatrix[row][colEnd] = num++;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // traverse left
                for (int col = colEnd; col >= colBegin; col--) {
                    spiralMatrix[rowEnd][col] = num++;
                }
                rowEnd--;
            }

            if (colBegin <= colEnd) {
                // traverse up
                for (int row = rowEnd; row >= rowBegin; row--) {
                    spiralMatrix[row][colBegin] = num++;
                }
                colBegin++;
            }

        }

        return spiralMatrix;
    }
}
