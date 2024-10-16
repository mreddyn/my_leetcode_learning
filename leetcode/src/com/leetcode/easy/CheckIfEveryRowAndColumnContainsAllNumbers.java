package com.leetcode.easy;

import java.util.HashSet;

public class CheckIfEveryRowAndColumnContainsAllNumbers {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            var rows = new HashSet<Integer>();
            var cols = new HashSet<Integer>();
            for (int col = 0; col < n; col++) {

                if (!rows.add(matrix[row][col])) {
                    return false;
                }

                if (!cols.add(matrix[col][row])) {
                    return false;
                }
            }

            if (rows.size() != n || cols.size() != n) {
                return false;
            }
        }

        return true;
    }
}
