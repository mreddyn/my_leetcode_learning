package com.neetcode.roadmap.stack;

import java.util.ArrayDeque;

public class ValidParenthesis {
    public boolean isValid(String s) {
        /*
         * Maintain a stack<Character>
         * if any type of opening bracket is encountered then push corresponding closing
         * bracket to stack.
         * if any type of closing closing bracket is encountered then check the top of
         * stack.
         * if it matches then pop, else return false.
         * After iterating the stack should be empty
         */
        int n = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
