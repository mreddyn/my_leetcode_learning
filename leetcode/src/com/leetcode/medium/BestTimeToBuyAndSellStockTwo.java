package com.leetcode.medium;

public class BestTimeToBuyAndSellStockTwo {
    public int maxProfit(int[] prices) {
        int profit = 0, n = prices.length;
        for (int i = 1; i < n; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
