package com.leetcode_daily_challenge;

import java.util.Arrays;

public class PolygonWithLargestPerimeter {
    private long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long runningSum = 0;
        int maxPossibleSides = -1;
        long maxPerimeter = -1;
        for (int i = 0; i < n - 1; i++) {
            runningSum += nums[i];
        }
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i] < runningSum) {
                maxPossibleSides = i;
                runningSum += nums[i];
                break;
            } else {
                runningSum -= nums[i - 1];

            }
        }
        maxPerimeter = runningSum;
        if (maxPossibleSides == -1) {
            return -1;
        }
        return maxPerimeter;
    }

    public static void main(String[] args) {
        PolygonWithLargestPerimeter solution = new PolygonWithLargestPerimeter();
        System.out.println(solution.largestPerimeter(new int[] { 5, 5, 50 }));
    }
}
