package com.leetcode_daily_challenge;

public class ScoreOfAString {
    private int scoreOfAString(String s) {
        int score = 0, n = s.length();
        for (int i = 1; i < n; i++) {
            score += Math.abs((s.charAt(i) - '0') - (s.charAt(i - 1) - '0'));
        }
        return score;
    }

    public static void main(String[] args) {
        ScoreOfAString scoreOfAString = new ScoreOfAString();
        System.out.println(scoreOfAString.scoreOfAString("hello"));
    }
}
