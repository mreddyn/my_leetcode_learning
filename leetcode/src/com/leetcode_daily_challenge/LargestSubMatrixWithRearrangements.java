package com.leetcode_daily_challenge;

import java.util.Arrays;

public class LargestSubMatrixWithRearrangements {
    private int largestSubMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int col = 0; col < cols; col++) {
            int maxConsecutiveOnes = 0;
            for (int row = 0; row < rows; row++) {
                if (matrix[row][col] == 1) {
                    maxConsecutiveOnes++;
                } else {
                    maxConsecutiveOnes = 0;
                }
                matrix[row][col] = maxConsecutiveOnes;
            }
        }

        int count = 0;
        for (int row = 0; row < rows; row++) {
            Arrays.sort(matrix[row]);
            for (int col = cols - 1; col >= 0; col--) {
                int width = matrix[row][col];
                int height = cols - col;
                count = Math.max(count, width * height);
            }
        }

        System.out.println(Arrays.deepToString(matrix));
        return count;
    }

    public static void main(String[] args) {
        LargestSubMatrixWithRearrangements largestSubMatrixWithRearrangements = new LargestSubMatrixWithRearrangements();
        int[][] matrix = { { 0, 1, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };
        System.out.println(largestSubMatrixWithRearrangements.largestSubMatrix(matrix));
    }
}
