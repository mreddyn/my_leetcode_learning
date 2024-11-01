package com.leetcode.easy;

public class DeleteCharsToMakeFancyString {
    public String makeFancyString(String s) {
        /*
         * Maintain a stack (StringBuilder) and iterate through the string s from 1 to
         * n-1
         * whenever we see a char that is equal to top of stack and next char then
         * continue.
         * else add it to stack
         */
        int n = s.length();
        var stack = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                stack.append(s.charAt(i));
            } else {
                if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == stack.charAt(stack.length() - 1)) {
                    continue;
                } else {
                    stack.append(s.charAt(i));
                }
            }
        }

        return stack.toString();
    }

    public String makeFancyStringApproachTwo(String s) {
        int n = s.length(), freq = 1;
        char prevChar = s.charAt(0);
        var sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == prevChar) {
                freq++;
            } else {
                freq = 1;
                prevChar = s.charAt(i);
            }

            if (freq < 3) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
