package com.leetcode_daily_challenge;

public class WordSearch {
    private boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0) && dfs(board, word, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (word.length() <= index) {
            return true;
        }
        if (row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] == '0'
                || board[row][col] != word.charAt(index)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '0';

        boolean left = dfs(board, word, index + 1, row, col - 1);
        boolean right = dfs(board, word, index + 1, row, col + 1);
        boolean up = dfs(board, word, index + 1, row - 1, col);
        boolean down = dfs(board, word, index + 1, row + 1, col);
        if (left || right || up || down) {
            return true;
        }
        board[row][col] = temp;
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(wordSearch.exist(board, word));
    }
}
