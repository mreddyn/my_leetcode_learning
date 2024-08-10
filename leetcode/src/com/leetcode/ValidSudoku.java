package com.leetcode;

import java.util.HashSet;

public class ValidSudoku {
    private boolean isValidSudoku(char[][] board) {
        int n = 9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];
        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < 9; col++) {
                char val = board[row][col];
                if (val == '.') {
                    continue;
                }

                // check in row
                if (rows[row].contains(val)) {
                    return false;
                }
                rows[row].add(val);

                // check in col
                if (cols[col].contains(val)) {
                    return false;
                }
                cols[col].add(val);

                // check in box
                int index = (row / 3) * 3 + (col / 3);
                if (boxes[index].contains(val)) {
                    return false;
                }
                boxes[index].add(val);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        validSudoku.isValidSudoku(null);
    }
}
