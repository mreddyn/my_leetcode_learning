package com.leetcode_daily_challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ReverseSubStringsBetweenEachPairOfBrackets {
    public String reverseParentheses(String s) {
        /*
         * Maintain two stacks of indices, one for left brackets, and other for
         * characters.
         * whenever a left bracket is encountered push its index to bracketIndexStack.
         * whenever a character(English letter) is encountered then push its index to
         * charIndexStack
         * if a closed bracket is encountered then do the following
         * pop the top open bracket index, now reverse(pop all of them and insert) the
         * indices in charIndexStack until the
         * index > last open bracket index
         * Finally pop the characters and append them to StringBuilder.
         */
        ArrayDeque<Integer> bracketIndexStack = new ArrayDeque<>();
        ArrayDeque<Integer> charIndexStack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                bracketIndexStack.push(i);
            } else if (ch == ')') {
                int lastOpenBracketIndex = bracketIndexStack.pop();
                List<Integer> indicesList = new ArrayList<>();
                while (!charIndexStack.isEmpty() && charIndexStack.peek() > lastOpenBracketIndex) {
                    indicesList.add(charIndexStack.pop());
                }
                int size = indicesList.size(), index = 0;
                while (index < size) {
                    charIndexStack.push(indicesList.get(index));
                    index++;
                }
            } else {
                charIndexStack.push(i);
            }

            System.out.println(charIndexStack);
        }
        int size = charIndexStack.size();
        StringBuilder resultString = new StringBuilder(size);
        while (size-- > 0) {
            resultString.append(s.charAt(charIndexStack.pop()));
        }
        return resultString.reverse().toString();
    }

    public String reverseParenthesesOptimizedApproach(String s) {
        /*
         * Wormhole technique :
         * First get the parentheses indices pairs in first pass
         * In Second pass, whenever a parentheses is encountered change the direction of
         * curIndex
         * if a character is encountered then add it to StringBuilder
         */
        int n = s.length();
        ArrayDeque<Integer> openParenthesesIndices = new ArrayDeque<>();
        int[] pair = new int[n];

        // first pass : pair up parentheses
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                openParenthesesIndices.push(i);
            } else if (s.charAt(i) == ')') {
                int j = openParenthesesIndices.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        // second pass : Build the result string
        StringBuilder result = new StringBuilder();
        for (int curIndex = 0, direction = 1; curIndex < n; curIndex += direction) {
            if (s.charAt(curIndex) == '(' || s.charAt(curIndex) == ')') {
                curIndex = pair[curIndex];
                direction = -direction;
            } else {
                result.append(s.charAt(curIndex));
            }
        }
        return result.toString();
    }
}
