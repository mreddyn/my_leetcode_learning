package com.leetcode.easy;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestKScores {
    public int minimumDifference(int[] nums, int k) {
        int minDiff = Integer.MAX_VALUE, n = nums.length;
        if (k == 1 || n == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int windowStart = 0, windowEnd = k - 1;
        while (windowEnd < n) {
            minDiff = Math.min(minDiff, Math.abs(nums[windowStart] - nums[windowEnd]));
            windowStart++;
            windowEnd++;
        }

        return minDiff;
    }

    public static void main(String[] args) {
        MinimumDifferenceBetweenHighestAndLowestKScores mKScores = new MinimumDifferenceBetweenHighestAndLowestKScores();
        System.out.println(mKScores.minimumDifference(new int[] { 87063, 61094, 44530, 21297, 95857, 93551, 9918 }, 6));
    }
}
