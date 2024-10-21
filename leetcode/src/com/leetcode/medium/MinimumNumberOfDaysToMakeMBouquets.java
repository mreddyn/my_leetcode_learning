package com.leetcode.medium;

public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int totalFlowers = bloomDay.length;
        if (totalFlowers < m * k) {
            return -1;
        }
        /*
         * We will do binary search for days,
         * if we can make m bouquets in D days then travel left
         * else travel right
         */
        int left = 1, right = 0;
        for (int bloom : bloomDay) {
            right = Math.max(right, bloom);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isFeasible(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isFeasible(int[] bloomDay, int m, int k, int day) {
        int bouquetCount = 0, flowers = 0;
        for (int bloom : bloomDay) {
            if (bloom > day) {
                flowers = 0;
            } else {
                flowers++;
            }

            if (flowers == k) {// if k consecutive flowers, then we can make bouquet
                bouquetCount++;
                flowers = 0;
            }
        }
        return bouquetCount >= m;
    }
}
