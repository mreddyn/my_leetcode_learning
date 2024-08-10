package com.company.servicenow;

public class BestTimeToBuyAndSellStock {
    private int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int n = prices.length, buyMin = prices[0], sellMax = prices[1], maxProfitSoFar = 0;
        maxProfitSoFar = Math.max(0, sellMax - buyMin);
        for (int i = 1; i < n; i++) {
            if (sellMax < prices[i]) {
                sellMax = prices[i];
                maxProfitSoFar = Math.max(maxProfitSoFar, sellMax - buyMin);
            }
            if (buyMin > prices[i]) {
                sellMax = prices[i];
                buyMin = prices[i];
            }
        }
        return maxProfitSoFar;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }
}
