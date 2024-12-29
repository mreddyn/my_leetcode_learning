package com.leetcode.medium;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        /*
         * if there are even number of negative numbers then we can convert all
         * negatives to positives by multiplying with -1 to get maximum sum
         * 
         * if there are odd negative numbers then we need to check for atleast one
         * zero.
         * if there is one zero then we can convert that remaining one negative to
         * positive. else we can not convert that one negative number.
         * In that case we need to find smallest positive number and greatest negative
         * number and one of them to positive to attain max sum.
         * 
         */
        long ans = 0;
        int rows = matrix.length, cols = matrix[0].length, negativeNumsCount = 0, zeroCount = 0;
        int greatestNegativeNumber = Integer.MIN_VALUE, smallestPositiveNumber = Integer.MAX_VALUE;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] < 0) {
                    negativeNumsCount++;
                    greatestNegativeNumber = Math.max(greatestNegativeNumber, matrix[row][col]);
                } else if (matrix[row][col] == 0) {
                    zeroCount++;
                } else {
                    smallestPositiveNumber = Math.min(smallestPositiveNumber, matrix[row][col]);
                }
                ans += Math.abs(matrix[row][col]);
            }
        }

        if (negativeNumsCount % 2 == 0) {
            // even number of negative numbers so we can convert all negative nums.
            return ans;

        } else {
            if (zeroCount > 0) {
                // zeros are present in the matrix
                return ans;
            } else {
                // except largest negative number convert all negative numbers to positive
                // edge case to keep negative number minimum
                if (Math.abs(smallestPositiveNumber) > Math.abs(greatestNegativeNumber)) {
                    ans += 2 * greatestNegativeNumber;
                } else {
                    ans -= 2 * smallestPositiveNumber;
                }
            }
        }

        return ans;
    }
}
