package com.leetcode.easy;

public class DetermineColorOfAChessBoardSquare {
    public boolean squareIsWhite(String coordinates) {
        int chessSquareDigitSum = (coordinates.charAt(0) - 'a' + 1) + (coordinates.charAt(1) - '0');
        // if the sum of square coordinates is even then the square is black and white
        // otherwise.
        return chessSquareDigitSum % 2 != 0;
    }
}
