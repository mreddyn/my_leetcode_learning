package com.leetcode_daily_challenge;

import java.util.Stack;

public class RemoveKDigits {
    private String removeKDigits(String num, int k) {
        int size = num.length(), index = 0;
        if (k == size) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        while (index < size) {
            // if the current digit is less then top element from stack, then pop it
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index));
            index++;
        }

        // edge case like "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }

        // construct the number from stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKDigits("10200", 1));
    }
}
