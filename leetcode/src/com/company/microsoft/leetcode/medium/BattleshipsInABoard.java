package com.company.microsoft.leetcode.medium;

public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        /*
         * Going over all cells, we can count only those that are the "first" cell of
         * the battleship.
         * First cell will be defined as the most top-left cell. We can check for first
         * cells by
         * only counting cells that do not have an 'X' to the left and do not have an
         * 'X' above them.
         */
        int battleshipsCount = 0, rows = board.length, cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (row > 0 && board[row - 1][col] == 'X') {
                    continue;
                }
                if (col > 0 && board[row][col - 1] == 'X') {
                    continue;
                }
                battleshipsCount++;
            }
        }

        return battleshipsCount;
    }
}
