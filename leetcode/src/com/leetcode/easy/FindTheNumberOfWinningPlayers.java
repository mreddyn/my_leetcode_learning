package com.leetcode.easy;

public class FindTheNumberOfWinningPlayers {
    public int winningPlayerCount(int n, int[][] pick) {
        /*
         * Since there a n players and they can only pick colors from 0 to 10, we can
         * store them in a 2D array where rows represents the players and columns
         * represents
         * the colors they picked. players[n][11]
         * Insert the colors for corresponding players and iterate through them to check
         * if they win,
         */
        int playerWinCount = 0;
        int[][] players = new int[n][11];
        for (int[] p : pick) {
            int player = p[0];
            int color = p[1];
            players[player][color]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                if (players[i][j] >= i + 1) {
                    playerWinCount++;
                    break;
                }
            }
        }

        return playerWinCount;
    }

    public static void main(String[] args) {
        FindTheNumberOfWinningPlayers fPlayers = new FindTheNumberOfWinningPlayers();
        fPlayers.winningPlayerCount(4, new int[][] { { 0, 0 }, { 1, 0 }, { 1, 0 }, { 2, 1 }, { 2, 1 }, { 2, 0 } });
    }
}
