package com.leetcode.medium;

import java.util.HashSet;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int totalRows = matrix.length, totalCols = matrix[0].length;
        var rows = new HashSet<Integer>();
        var cols = new HashSet<Integer>();
        // Iterate through matrix, add row and col number if a encountered a zero
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (matrix[row][col] == 0) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }

        // now iterate through the matrix and set the [row][col] to zero
        // if row or col is in rows or cols
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (rows.contains(row) || cols.contains(col)) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public void setZeroesApproachTwo(int[][] matrix) {
        int totalRows = matrix.length, totalCols = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        // see if the we encounter a zero in first column
        for (int row = 0; row < totalRows; row++) {
            if (matrix[row][0] == 0) {
                firstCol = true;
                break;
            }
        }

        // see if we encounter a zero in first row
        for (int col = 0; col < totalCols; col++) {
            if (matrix[0][col] == 0) {
                firstRow = true;
                break;
            }
        }

        // Iterate through the matrix if a zero is encountered then mark the
        // its row and colum as zero
        for (int row = 1; row < totalRows; row++) {
            for (int col = 1; col < totalCols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // now Iterate through the matrix and set zeroes
        for (int row = 1; row < totalRows; row++) {
            for (int col = 1; col < totalCols; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRow) {
            for (int col = 0; col < totalCols; col++) {
                matrix[0][col] = 0;
            }
        }

        if (firstCol) {
            for (int row = 0; row < totalRows; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
