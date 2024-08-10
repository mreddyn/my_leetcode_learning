package com.oa.company.IBM;

import java.util.Arrays;

public class MedianPriceAdjustment {
    private int minMovesToAdjustMedian(int[] prices, int k) {
        Arrays.sort(prices);
        int n = prices.length;
        int moves = 0;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                moves += Math.max(0, prices[i] - k);
            } else if (i == n / 2) {
                moves += Math.abs(prices[i] - k);
            } else {
                moves += Math.max(0, k - prices[i]);
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        MedianPriceAdjustment medianPriceAdjustment = new MedianPriceAdjustment();
        int[] prices = { 4, 2, 1, 4, 7 };
        int k = 3;
        System.out.println(medianPriceAdjustment.minMovesToAdjustMedian(prices, k));
    }
}
