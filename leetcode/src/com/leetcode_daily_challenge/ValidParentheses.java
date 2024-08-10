package com.leetcode_daily_challenge;

public class ValidParentheses {
    public boolean isValid(String s) {
        int round;
        int brace;
        int box;
        round = 0;
        brace = 0;
        box = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                round++;
            } else if (ch == '{') {
                brace++;
            } else if (ch == '[') {
                box++;
            } else if (ch == ')') {
                round--;
            } else if (ch == '}') {
                brace--;
            } else {
                box--;
            }
            if (round < 0 || brace < 0 || box < 0) {
                return false;
            }
        }
        return (round == 0 && brace == 0 && box == 0);
    }
}
