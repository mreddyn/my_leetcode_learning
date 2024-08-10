package com.oa.company.IBM;

public class ChessTournament {
    private int getPotentialOfWinner(int[] potential, int k) {
        int winner = potential[0];
        int consecutiveWins = 1;
        for (int i = 1; i < potential.length; i++) {
            if (potential[i] > winner) {
                winner = potential[i];
                consecutiveWins = 1;
            } else {
                consecutiveWins++;
                if (consecutiveWins == k) {
                    break;
                }
            }
        }

        return winner;
    }

    public static void main(String[] args) {
        ChessTournament chessTournament = new ChessTournament();
        System.out.println(chessTournament.getPotentialOfWinner(new int[] { 1, 3, 2, 4, 5 }, 2));
        System.out.println(chessTournament.getPotentialOfWinner(new int[] { 3, 2, 1, 4 }, 3));
    }
}
