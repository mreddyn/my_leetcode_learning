package com.company.amazon.leetcode;

public class MatrixDiagonalSum {
    private int diagonalSum(int[][] mat) {
        int totalSum = 0, diagonalOneSum = 0, diagonalTwoSum = 0, rows = mat.length, cols = mat[0].length;
        int row = 0, col = 0;
        while (row < rows && col < cols) {
            diagonalOneSum += mat[row][col];
            row++;
            col++;
        }
        row = 0;
        col = cols - 1;
        while (row < rows && col >= 0) {
            if (row != col) {
                diagonalTwoSum += mat[row][col];
            }
            row++;
            col--;
        }
        totalSum = diagonalOneSum + diagonalTwoSum;

        return totalSum;
    }

    public static void main(String[] args) {
        MatrixDiagonalSum matrixDiagonalSum = new MatrixDiagonalSum();
        int[][] mat = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
        System.out.println(matrixDiagonalSum.diagonalSum(mat));
    }
}
