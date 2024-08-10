package com.company.servicenow;

import java.util.Stack;

public class LongestHighTempDuration {

    public static int[] transformSeries(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            // The stack is empty when the current temperature is the highest so far
            result[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = { 30, 50, 60, 20, 10, 40, 60, 90 };
        int[] result = transformSeries(temperatures);
        for (int i : result) {
            System.out.print(i + " ");
        }
        // Output: 1 2 3 1 1 3 7 8
    }
}
