package com.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    private static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (token.charAt(0) == '+' && token.length() == 1) {
                int first_operand = st.pop();
                int second_operand = st.pop();
                st.push(second_operand + first_operand);
            } else if (token.charAt(0) == '-' && token.length() == 1) {
                int first_operand = st.pop();
                int second_operand = st.pop();
                st.push(second_operand - first_operand);
            } else if (token.charAt(0) == '*' && token.length() == 1) {
                int first_operand = st.pop();
                int second_operand = st.pop();
                st.push(second_operand * first_operand);
            } else if (token.charAt(0) == '/' && token.length() == 1) {
                int first_operand = st.pop();
                int second_operand = st.pop();
                st.push(second_operand / first_operand);
            } else {
                st.push(Integer.parseInt(token));
            }
            System.out.println(st);
        }
        return st.peek();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" }));
        System.out.println(evalRPN(new String[] { "4", "13", "5", "/", "+" }));
        System.out.println(evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5",
                "+" }));
    }
}
