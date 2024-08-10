package com.leetcode.easy;

import java.util.ArrayDeque;

public class FinalPricesWithSpecialDiscountInShop {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }

        return prices;
    }

    public int[] finalPricesApproachTwo(int[] prices) {
        /*
         * Maintain a monotonic increasing stack containing indices.
         * Iterate through the prices.
         * Whenever the prices encountered in the stack is greater than or equal then
         * subtract
         * the current price from the price encountered on top of the stack and pop it
         * from stack.
         */
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }

        return prices;
    }
}
