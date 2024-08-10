package com.company.microsoft.leetcode.easy;

import java.util.Arrays;

public class MinimumAverageOfSmallestAndLargestElements {
    public double minimumAverage(int[] nums) {
        int n = nums.length;
        double minAverage = Double.MAX_VALUE;
        Arrays.sort(nums);
        int left = 0, right = n - 1;
        while (left < right) {
            int minElement = nums[left];
            int maxElement = nums[right];
            double curAverage = (double) (minElement + maxElement) / 2;
            minAverage = Math.min(minAverage, curAverage);
            left++;
            right--;
        }
        return minAverage;
    }
}
