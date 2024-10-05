package com.company.amazon.leetcode.easy;

public class CheckIfTwoChessBoardSquaresHaveSameColor {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        /*
         * Convert the column character to a numerical value using its ASCII
         * code.Convert the row character directly since it is already a
         * number.Calculate the sum of the column and row indices for both
         * coordinates.If both sums are either even or odd, the squares have the same
         * color.
         */
        int firstSquareDigitSum = (coordinate1.charAt(0) - 'a' + 1) + (coordinate1.charAt(1) - '0');
        int secondSquareDigitSum = (coordinate2.charAt(0) - 'a' + 1) + (coordinate2.charAt(1) - '0');

        return firstSquareDigitSum % 2 == secondSquareDigitSum % 2;
    }
}
