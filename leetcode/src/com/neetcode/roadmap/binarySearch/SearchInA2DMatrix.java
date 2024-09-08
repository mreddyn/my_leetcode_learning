package com.neetcode.roadmap.binarySearch;

public class SearchInA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
         * search for target starting from last column in first row.
         * if target is found then return true.
         * else if target is less than current row and last element then search for
         * target in that row.
         * else continue.
         */
        int rows = matrix.length, cols = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            if (target == matrix[row][cols - 1]) {
                return true;
            } else if (target < matrix[row][cols - 1]) {
                // search in that row
                return helper(matrix, row, target);
            } else {
                continue;
            }
        }

        return false;
    }

    private boolean helper(int[][] matrix, int row, int target) {
        for (int col = matrix[0].length - 1; col >= 0; col--) {
            if (target == matrix[row][col]) {
                return true;
            }
        }
        return false;
    }
}
