package com.company.microsoft.leetcode.easy;

public class FindClosestNumberToZero {
    public int findClosestNumber(int[] nums) {
        int n = nums.length, closestNumberToZero = Integer.MAX_VALUE, curClosestNumberToZero,
                closestNumberDistance = Integer.MAX_VALUE, curNumberDistance;
        for (int i = 0; i < n; i++) {
            curNumberDistance = Math.abs(nums[i]);
            curClosestNumberToZero = nums[i];
            if (closestNumberDistance == curNumberDistance && closestNumberToZero < curClosestNumberToZero) {
                closestNumberToZero = curClosestNumberToZero;
                continue;
            }
            if (closestNumberDistance > curNumberDistance) {
                closestNumberToZero = curClosestNumberToZero;
                closestNumberDistance = curNumberDistance;
            }
        }

        return closestNumberToZero;
    }
}
