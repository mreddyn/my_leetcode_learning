package com.oa.company.amazon;

import java.util.Stack;

public class MaxBalancedSubStringScore {

    public static int getMaxScore(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxScore = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i); // Push the index of the opening parenthesis
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    int startIndex = stack.pop(); // Pop the index of the matching opening parenthesis
                    int score = i - startIndex; // Calculate the score for this balanced pair
                    maxScore = Math.max(maxScore, score); // Update the maximum score
                }
            }
        }

        return maxScore + 1;
    }

    public static void main(String[] args) {
        String s1 = "(())";
        System.out.println(getMaxScore(s1)); // Output: 4

        String s2 = "(()))";
        System.out.println(getMaxScore(s2)); // Output: 4

        String s3 = "(()((())";
        System.out.println(getMaxScore(s3)); // Output: 4

        String s4 = "()()";
        System.out.println(getMaxScore(s4)); // Output: 2
    }
}
