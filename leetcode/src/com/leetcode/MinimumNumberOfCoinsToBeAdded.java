package com.leetcode;

import java.util.Arrays;

public class MinimumNumberOfCoinsToBeAdded {
    public int minimumAddedCoins(int[] coins, int target) {
        int additionalCoins, n = coins.length, currentMax, index;
        additionalCoins = 0;
        currentMax = 0;
        index = 0;
        Arrays.sort(coins);
        while (currentMax < target) {
            if (index < n && coins[index] <= currentMax + 1) {
                currentMax += coins[index];
                index++;
            } else {
                currentMax += currentMax + 1;
                additionalCoins++;
            }
        }

        return additionalCoins;
    }
}
