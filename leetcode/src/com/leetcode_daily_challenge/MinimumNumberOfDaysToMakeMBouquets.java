package com.leetcode_daily_challenge;

public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int minDays = -1, totalFlowers = bloomDay.length;
        if (totalFlowers < m * k) {
            return -1;
        }
        int start = 0, end = 0;
        for (int day : bloomDay) {
            end = Math.max(day, end);
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int bouquets = getNumberOfBouquets(bloomDay, mid, k);
            if (bouquets >= m) {
                minDays = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minDays;
    }

    private int getNumberOfBouquets(int[] bloomDay, int mid, int k) {
        int numberOfBouquets = 0, count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            // if flower is bloomed then count (check for consecutive) else reset the
            // counter
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                numberOfBouquets++;
                count = 0;
            }
        }

        return numberOfBouquets;
    }

}
