package com.leetcode_daily_challenge;

import java.util.Arrays;

public class BagOfTokens {
    private int bagOfTokensScore(int[] tokens, int power) {
        int tokensLength = tokens.length;
        if (tokensLength == 0) {
            return 0;
        }
        int score = 0;
        Arrays.sort(tokens);
        int leftPointer = 0;
        int rightPointer = tokensLength - 1;
        int maxScore = 0;
        while (leftPointer < rightPointer) {
            if (power >= tokens[leftPointer]) {
                power = power - tokens[leftPointer];
                leftPointer++;
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power = power + tokens[rightPointer];
                score--;
                rightPointer--;
            } else {
                break;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        BagOfTokens bagOfTokens = new BagOfTokens();
        int[] tokens = { 100, 200, 300, 400 };
        int power = 200;
        System.out.println(bagOfTokens.bagOfTokensScore(tokens, power));
    }
}
