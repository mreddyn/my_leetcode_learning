package com.leetcode.medium;

import java.util.ArrayDeque;

public class MinimumInsertionsToBalanceAParenthesisString {
    public int minInsertions(String s) {
        var stack = new ArrayDeque<Integer>();
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // if we encountered a open bracket
                // and if the stack is empty or 2 on top we push another 2
                // as this open brace needs two closing braces
                if (stack.isEmpty() || stack.peek() == 2) {
                    stack.push(2);
                } else {
                    // we have 1 on top of stack
                    // this indicates that previously for a open bracket there was
                    // only one closing bracket and needs another one.
                    // so we pop that one closing bracket and push two to stack.
                    // and increment res since we are missing one closing bracket
                    stack.pop();
                    stack.push(2);
                    res++;
                }
            } else {
                if (stack.isEmpty()) {
                    // we have encountered a lone closing bracket, this means
                    // it needs one open brace and another closing brace to balance
                    res++; // for open brace insertion
                    stack.push(1);
                } else if (stack.peek() == 1) {
                    // if we have one on top of stack, this means we encountered a
                    // second closing brace, so we just pop it
                    stack.pop();
                } else if (stack.peek() == 2) {
                    // this is the first closing brace for open brace.
                    // so we pop the 2 and add 1 to stack
                    stack.pop();
                    stack.push(1);
                }
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
