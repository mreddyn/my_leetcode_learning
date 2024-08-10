package com.company.servicenow;

import java.util.Stack;

public class ValidParenthesisString {
    private boolean checkValidString(String s) {
        int n;
        n = s.length();
        Stack<Integer> starStack = new Stack<>();
        Stack<Integer> leftParenthesisStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftParenthesisStack.add(i);
            } else if (c == '*') {
                starStack.add(i);
            } else {
                if (leftParenthesisStack.isEmpty()) {
                    if (starStack.isEmpty()) {
                        return false;
                    } else {
                        starStack.pop();
                    }
                } else {
                    leftParenthesisStack.pop();
                }
            }
        }

        while (!leftParenthesisStack.isEmpty() && !starStack.isEmpty()) {
            int starIndex = starStack.pop();
            int leftParenthesisIndex = leftParenthesisStack.pop();
            if(leftParenthesisIndex > starIndex) {
                return false;
            }
        }
        return leftParenthesisStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString(
                "**(("));
    }
}
