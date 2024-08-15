package com.oa.company.tiktok;

import java.util.Stack;

public class TikTokMetricAnalysis {

    public static int getMaxGoodSubarrayLength(int limit, int[] financialMetrics) {
        int n = financialMetrics.length;
        if (n == 0)
            return -1;

        // Arrays to store the nearest smaller elements' indexes
        int[] leftBound = new int[n];
        int[] rightBound = new int[n];

        // Calculate the nearest smaller elements' indexes to the left
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && financialMetrics[stack.peek()] >= financialMetrics[i]) {
                stack.pop();
            }
            leftBound[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Calculate the nearest smaller elements' indexes to the right
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && financialMetrics[stack.peek()] >= financialMetrics[i]) {
                stack.pop();
            }
            rightBound[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int maxLength = -1;

        // Compute the maximum length of valid subarrays
        for (int i = 0; i < n; i++) {
            int len = rightBound[i] - leftBound[i] - 1;
            if (len >= (double) limit / financialMetrics[i]) {
                maxLength = Math.max(maxLength, len);
            }
        }

        return maxLength == -1 ? -1 : maxLength;

    }

    public static void main(String[] args) {
        int[] financialMetrics = { 1, 3, 4, 3, 1 };
        int limit = 6;
        System.out.println(getMaxGoodSubarrayLength(limit, financialMetrics)); // Output: 2
    }

}
