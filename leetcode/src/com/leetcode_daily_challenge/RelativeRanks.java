package com.leetcode_daily_challenge;

import java.util.Arrays;

public class RelativeRanks {
    private String[] findRelativeRanks(int[] score) {
        String[] ranks = new String[score.length];
        int[][] pair = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            pair[i][0] = score[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
        for (int i = 0; i < score.length; i++) {
            if (i == 0) {
                ranks[pair[i][1]] = "Gold Medal";
            } else if (i == 1) {
                ranks[pair[i][1]] = "Silver Medal";
            } else if (i == 2) {
                ranks[pair[i][1]] = "Bronze Medal";
            } else {
                ranks[pair[i][1]] = (i + 1) + "";
            }
        }
        return ranks;
    }

    public static void main(String[] args) {
        RelativeRanks relativeRanks = new RelativeRanks();
        int[] score = { 10, 3, 8, 9, 4 };
        relativeRanks.findRelativeRanks(score);
    }
}
