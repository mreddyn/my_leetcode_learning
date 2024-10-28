package com.company.amazon.leetcode.easy;

import java.util.ArrayDeque;

public class MinimumStringLengthAfterRemovingSubStrings {
    public int minLength(String s) {
        var sb = new StringBuilder(s);
        while (sb.length() > 0) {
            int abIndex = sb.indexOf("AB");
            int cdIndex = sb.indexOf("CD");
            if (abIndex == -1 && cdIndex == -1) {
                break;
            }
            if (abIndex != -1) {
                sb.delete(abIndex, abIndex + 2);
            }
            cdIndex = sb.indexOf("CD");
            if (cdIndex != -1) {
                sb.delete(cdIndex, cdIndex + 2);
            }
        }

        return sb.length();
    }

    public int minLengthApproachTwo(String s) {
        /*
         * Iterate through the string and push each char to the stack
         * if we encounter a B we look for A on top of stack and pop it.
         * if we encounter a D we look for C on top of stack and pop it.
         */
        int n = s.length();
        var stack = new ArrayDeque<Character>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'B' && !stack.isEmpty() && stack.peek() == 'A') {
                stack.pop();
            } else if (c == 'D' && !stack.isEmpty() && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }

    public int minLengthApproachThree(String s) {
        int n = s.length(), writePtr = 0;
        var ch = s.toCharArray();
        for (int readPtr = 0; readPtr < n; readPtr++) {
            // write the current character to the writePtr position
            ch[writePtr] = s.charAt(readPtr);

            // check if previous character is 'A' or 'C' and
            // current character is +1 of previous character
            if (writePtr > 0 && (ch[writePtr - 1] == 'A' || ch[writePtr - 1] == 'C') &&
                    ch[writePtr] == ch[writePtr - 1] + 1) {
                writePtr--;
            } else {
                writePtr++;
            }
        }

        return writePtr;
    }
}
