package com.leetcode_daily_challenge;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {
    private int maxCoins(int[] piles) {
        int n = piles.length;
        int maxCoins = 0;
        Arrays.sort(piles);
        for (int i = n - 2; i >= n / 3; i -= 2) {
            maxCoins += piles[i];
        }
        return maxCoins;
    }

    public static void main(String[] args) {
        MaximumNumberOfCoinsYouCanGet maximumNumberOfCoinsYouCanGet = new MaximumNumberOfCoinsYouCanGet();
        int[] piles = { 9, 8, 7, 6, 5, 1, 2, 3, 4 };
        System.out.println(maximumNumberOfCoinsYouCanGet.maxCoins(piles));
    }
}
