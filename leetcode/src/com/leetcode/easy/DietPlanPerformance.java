package com.leetcode.easy;

public class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int totalPoints = 0, n = calories.length;
        int windowSum = 0, windowEnd = 0, windowStart = 0;
        for (windowEnd = 0; windowEnd < k; windowEnd++) {
            windowSum += calories[windowEnd];
        }

        totalPoints += calculatePerformance(windowSum, lower, upper);

        while (windowEnd < n) {
            windowSum += calories[windowEnd++];
            windowSum -= calories[windowStart++];
            totalPoints += calculatePerformance(windowSum, lower, upper);
        }

        return totalPoints;
    }

    private int calculatePerformance(int totalCalories, int lower, int upper) {
        if (totalCalories < lower) {
            return -1;
        } else if (totalCalories > upper) {
            return 1;
        } else {
            return 0;
        }
    }
}
