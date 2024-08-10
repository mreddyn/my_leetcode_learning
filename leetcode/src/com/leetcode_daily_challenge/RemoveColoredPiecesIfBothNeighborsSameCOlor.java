package com.leetcode_daily_challenge;

public class RemoveColoredPiecesIfBothNeighborsSameCOlor {
    private boolean winnerOfGame(String colors) {
        int n = colors.length();
        int aliceCount = 0;
        int bobCount = 0;
        int aliceTurns = 0;
        int bobTurns = 0;
        for (int index = 0; index < n; index++) {
            if (colors.charAt(index) == 'A') {
                aliceCount++;
                bobCount = 0;
            } else {
                bobCount++;
                aliceCount = 0;
            }
            if (aliceCount >= 3) {
                aliceTurns++;
            }
            if (bobCount >= 3) {
                bobTurns++;
            }
        }
        System.out.println(aliceTurns + " " + bobTurns);
        return aliceTurns > bobTurns;
    }

    public static void main(String[] args) {
        String colors = "ABBBBBBBAAA";
        RemoveColoredPiecesIfBothNeighborsSameCOlor rcp = new RemoveColoredPiecesIfBothNeighborsSameCOlor();
        System.out.println(rcp.winnerOfGame(colors));
    }
}
