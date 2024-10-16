package com.leetcode.medium;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        var output = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = liveNeighborCount(board, row, col);

                if (board[row][col] == 1 && count < 2) {
                    output[row][col] = 0;
                } else if (board[row][col] == 1 && (count == 2 || count == 3)) {
                    output[row][col] = 1;
                } else if (board[row][col] == 1 && count > 3) {
                    output[row][col] = 0;
                } else if (board[row][col] == 0 && count == 3) {
                    output[row][col] = 1;
                }
            }
        }

        // copy the output to board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = output[row][col];
            }
        }
    }

    private int liveNeighborCount(int[][] board, int row, int col) {
        int count = 0;
        var directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 },
                { 1, 1 } };
        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                count += board[x][y];
            }
        }

        return count;
    }

    private final int DEAD = 0;
    private final int ALIVE = 1;
    private final int DEADTOALIVE = 2;
    private final int ALIVETODEAD = 3;

    public void gameOfLifeApproachTwo(int[][] board) {
        int rows = board.length, cols = board[0].length;
        // Iterate through the board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int alive = getLiveNeighborCount(board, row, col);

                // if current cell is DEAD but has three neighbor live cells then make it alive
                if (board[row][col] == DEAD) {
                    if (alive == 3) {
                        board[row][col] = DEADTOALIVE;
                    }
                } else {
                    // in case the current cell is ALIVE
                    // but if it has only one alive neighbor or more than 3 neighbors
                    // then make is DEAD
                    if (alive < 2 || alive > 3) {
                        board[row][col] = ALIVETODEAD;
                    }
                }
            }

        }

        // revert the board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == DEADTOALIVE) {
                    board[row][col] = ALIVE;
                } else if (board[row][col] == ALIVETODEAD) {
                    board[row][col] = DEAD;
                }
            }
        }
    }

    private int getLiveNeighborCount(int[][] board, int row, int col) {
        int count = 0;
        var directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 },
                { 1, 1 } };
        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length
                    && (board[x][y] == ALIVE || board[x][y] == ALIVETODEAD)) {
                count++;
            }
        }

        return count;
    }
}
