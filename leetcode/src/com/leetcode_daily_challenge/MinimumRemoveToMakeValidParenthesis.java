package com.leetcode_daily_challenge;

import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {
    private String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> leftParenthesisStack = new Stack<>();
        char ch[] = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (ch[i] == '(') {
                leftParenthesisStack.add(i);
            } else if (ch[i] == ')') {
                if (leftParenthesisStack.isEmpty()) {
                    ch[i] = '$';
                } else {
                    leftParenthesisStack.pop();
                }
            } else {
                continue;
            }
        }
        while (!leftParenthesisStack.isEmpty()) {
            int index = leftParenthesisStack.pop();
            ch[index] = '$';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '$') {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinimumRemoveToMakeValidParenthesis minimumRemoveToMakeValidParenthesis = new MinimumRemoveToMakeValidParenthesis();
        System.out.println(minimumRemoveToMakeValidParenthesis.minRemoveToMakeValid(""));
    }
}
