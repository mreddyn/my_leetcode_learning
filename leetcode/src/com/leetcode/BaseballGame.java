package com.leetcode;

import java.util.ArrayDeque;
import java.util.Iterator;

public class BaseballGame {
    public int calPoints(String[] operations) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int totalSum = 0;
        for (String operation : operations) {

            if (operation.equals("C")) {
                stack.pop();
            } else if (operation.equals("D")) {
                int previousScore = stack.peek();
                int currentScore = previousScore * 2;
                stack.push(currentScore);
            } else if (operation.equals("+")) {
                // add two previous scores
                int scoreOne = stack.pop();
                int scoreTwo = stack.pop();
                int sumOfScoreOneAndTwo = scoreOne + scoreTwo;
                stack.push(scoreTwo);
                stack.push(scoreOne);
                stack.push(sumOfScoreOneAndTwo);
            } else {
                int score = Integer.parseInt(operation);
                stack.push(score);
            }

            System.out.println(stack);
        }

        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            totalSum += iterator.next();
        }
        return totalSum;
    }

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" });
    }
}
