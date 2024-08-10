package com.leetcode;

import java.util.ArrayDeque;

public class RemovingStarsFromAString {
    public String removeStars(String s) {
        /*
         * Maintain a stack for characters, if a non-star char is encountered then push
         * it to stack
         * if a star is encountered and stack is not empty then pop the char from stack
         * Finally pop the chars from stack and append them to StringBuilder.
         * Reverse the StringBuilder and return
         */
        int n = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != '*') {
                stack.push(ch);
            } else if (ch == '*' && !stack.isEmpty()) {
                stack.pop();
            }
        }
        int size = stack.size();
        StringBuilder sb = new StringBuilder(size);
        while (size-- > 0) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public String removeStarsTwoPointerApproach(String s) {
        /*
         * We will maintain two pointers, one to point the current char in s, and other
         * to point
         * nonStarChar.
         * If we encounter a star char then we decrement the nonStarIndex (this
         * overwrites the current char)
         * else we add current char at nonStartIndex place
         */
        int n = s.length(), nonStarIndex = 0;
        char[] ch = new char[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                nonStarIndex--;
            } else {
                ch[nonStarIndex++] = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nonStarIndex; i++) {
            sb.append(ch[i]);
        }

        return sb.toString();
    }
}
