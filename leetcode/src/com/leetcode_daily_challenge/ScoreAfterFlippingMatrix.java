package com.leetcode_daily_challenge;

public class ScoreAfterFlippingMatrix {
    private int matrixScore(int[][] grid) {
        int score = 0, rows = grid.length, cols = grid[0].length;
        // check all rows for first column, if '0' then flip
        for (int row = 0; row < rows; row++) {
            int col = 0;
            if (grid[row][col] == 0) {
                for (col = 0; col < cols; col++) {
                    grid[row][col] = 1 - grid[row][col];
                }
            }
        }

        // check all columns, if the count of zeros is greater than ones then flip
        for (int col = 1; col < cols; col++) {
            int colZerosCount = 0;
            for (int row = 0; row < rows; row++) {
                if (grid[row][col] == 0) {
                    colZerosCount++;
                }
            }
            if (colZerosCount > rows - colZerosCount) {
                for (int row = 0; row < rows; row++) {
                    grid[row][col] = 1 - grid[row][col];
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            char[] binaryArray = new char[cols];
            for (int col = 0; col < cols; col++) {
                binaryArray[col] = Character.forDigit(grid[row][col], 2);
            }
            String binaryString = new String(binaryArray);
            score += Integer.parseInt(binaryString, 2);
        }

        return score;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix afterFlippingMatrix = new ScoreAfterFlippingMatrix();
        afterFlippingMatrix.matrixScore(new int[][] { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } });
    }
}
