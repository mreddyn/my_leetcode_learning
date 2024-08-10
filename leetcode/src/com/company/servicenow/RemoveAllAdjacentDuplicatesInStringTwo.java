package com.company.servicenow;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringTwo {
    private String removeDuplicates(String s, int k) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        Stack<Pair> stack = new Stack<>();
        for (int index = n - 1; index >= 0; index--) {
            char curChar = s.charAt(index);
            if (stack.isEmpty()) {
                Pair pair = new Pair(curChar, 1);
                stack.add(pair);
            } else {
                Pair pair = stack.pop();
                char topChar = pair.c;
                int topCharCount = pair.count;
                if (curChar == topChar) {
                    if (topCharCount + 1 == k) {
                        continue;
                    } else {
                        topCharCount++;
                        stack.add(new Pair(curChar, topCharCount));
                    }
                } else {
                    stack.add(pair);
                    stack.add(new Pair(curChar, 1));
                }
            }
        }

        int size = stack.size();
        StringBuilder sb = new StringBuilder();
        while (size-- > 0) {
            Pair pair = stack.pop();
            if (pair.count == k) {
                continue;
            } else {
                int count = pair.count;
                while (count-- > 0) {
                    sb.append(pair.c);
                }
            }
        }
        return sb.toString();
    }

    class Pair {
        char c;
        int count;

        Pair() {
        }

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringTwo removeAllAdjacentDuplicatesInStringTwo = new RemoveAllAdjacentDuplicatesInStringTwo();
        System.out.println(removeAllAdjacentDuplicatesInStringTwo.removeDuplicates("deeedbbcccbdaa", 3)); // aa
        System.out.println(removeAllAdjacentDuplicatesInStringTwo.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
