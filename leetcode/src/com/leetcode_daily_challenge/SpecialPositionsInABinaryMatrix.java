package com.leetcode_daily_challenge;

public class SpecialPositionsInABinaryMatrix {
    private int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] rowOnesCount = new int[mat.length];
        int[] colOnesCount = new int[mat[0].length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 1) {
                    rowOnesCount[row]++;
                    colOnesCount[col]++;
                }
            }
        }

        int specialCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 1 && rowOnesCount[row] == 1 && colOnesCount[col] == 1) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }

    public static void main(String[] args) {
        System.out.println(new SpecialPositionsInABinaryMatrix()
                .numSpecial(new int[][] { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 0, 0 } }));
    }
}
