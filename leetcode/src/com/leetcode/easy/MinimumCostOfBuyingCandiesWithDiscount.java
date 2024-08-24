package com.leetcode.easy;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        /*
         * for the the max value we need to buy the candy
         * for the second max value we also need to buy the candy.
         * for the third max value we can get it for free.
         * We will sort the cost array and iterate through backwards.
         */
        int minCost = 0, n = cost.length;
        if (n == 1) {
            return cost[0];
        }
        Arrays.sort(cost);
        int firstCandyPtr = n - 1, secondCandyPtr = n - 2;
        while (firstCandyPtr >= 0) {
            minCost += cost[firstCandyPtr];
            minCost += (secondCandyPtr >= 0) ? cost[secondCandyPtr] : 0;
            firstCandyPtr -= 3;
            secondCandyPtr -= 3;
        }

        return minCost;
    }

    public int minimumCostApproachTwo(int[] cost) {
        Arrays.sort(cost);
        int minCost = 0, n = cost.length;
        for (int i = 0; i < n; i++) {
            if (i % 3 != n % 3) {
                minCost += cost[i];
            }
        }

        return minCost;
    }

    public int minimumCostApproachThree(int[] cost) {
        Arrays.sort(cost);
        int minCost = 0, count = 0, n = cost.length;
        for (int i = n - 1; i >= 0; i--) {
            if (count == 2) {
                count = 0;
                continue;
            }
            minCost += cost[i];
            count++;
        }

        return minCost;
    }
}
