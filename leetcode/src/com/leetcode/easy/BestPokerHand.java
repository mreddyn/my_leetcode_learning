package com.leetcode.easy;

public class BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        var rankMap = new int[14];
        var suitMap = new int[4];
        for (int rank : ranks) {
            rankMap[rank]++;
        }

        for (char suit : suits) {
            suitMap[suit - 'a']++;
        }

        for (int i = 0; i < 4; i++) {
            // checking for Flush if we have five cards of same suit
            if (suitMap[i] == 5) {
                return "Flush";
            }
        }

        for (int i = 0; i < 14; i++) {
            if (rankMap[i] >= 3) {
                // checking for Three of a Kind, if there exists three cards of same rank
                return "Three of a Kind";
            }
        }

        for (int i = 0; i < 14; i++) {
            if (rankMap[i] == 2) {
                // checking for Pair, if there exists two cards of same rank
                return "Pair";
            }
        }

        return "High Card";
    }
}
