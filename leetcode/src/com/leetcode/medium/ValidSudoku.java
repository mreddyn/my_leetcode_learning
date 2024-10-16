package com.leetcode.medium;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        var seen = new HashSet<String>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number == '.') {
                    continue;
                }

                if (!seen.add(number + " in row " + i)) {
                    return false;
                }

                if (!seen.add(number + " in column " + j)) {
                    return false;
                }

                if (!seen.add(number + " in box " + i / 3 + "-" + j / 3)) {
                    return false;
                }
            }
        }

        return true;
    }
}
