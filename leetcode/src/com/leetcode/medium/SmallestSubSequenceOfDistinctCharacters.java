package com.leetcode.medium;

import java.util.ArrayDeque;

public class SmallestSubSequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {
        /*
         * Find the index of last occurrence for each character.
         * Use a stack to keep the characters for result.
         * Loop on each character in the input string S,
         * if the current character is smaller than the last character in the stack,
         * and the last character exists in the following stream,
         * we can pop the last character to get a smaller result.
         */
        int[] lastIndexOfChar = new int[26];
        int[] charSeen = new int[26];
        int n = s.length();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            lastIndexOfChar[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            // current char
            int c = s.charAt(i) - 'a';

            if (charSeen[c]++ > 0) {
                // if we already seen the char in the stack then continue;
                continue;
            }

            while (!stack.isEmpty() && c < stack.peek() && i < lastIndexOfChar[stack.peek()]) {
                // if the current char is less then top char and if we are sure that top char
                // occurs in future then we pop it from stack
                charSeen[stack.pop()] = 0;
            }

            stack.push(c);
        }

        int size = stack.size();
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            sb.append((char) (stack.pop() + 'a'));
        }
        return sb.reverse().toString();
    }
}
