package com.leetcode.medium;

import java.util.ArrayDeque;

public class ScoreOfParenthesis {
    public int scoreOfParentheses(String s) {
        int score = 0, n = s.length();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            System.out.println(stack);
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }

    public static void main(String[] args) {
        ScoreOfParenthesis sParenthesis = new ScoreOfParenthesis();
        sParenthesis.scoreOfParentheses("(()(()))");
    }
}
