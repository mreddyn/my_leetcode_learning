package com.leetcode_daily_challenge;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    private int minPairSum(int[] nums) {
        int n = nums.length;
        int leftIndex = 0, rightIndex = n - 1;
        int maximumPairSum = Integer.MIN_VALUE;
        Arrays.sort(nums);
        while (leftIndex < rightIndex) {
            maximumPairSum = Math.max(maximumPairSum, nums[leftIndex] + nums[rightIndex]);
            leftIndex++;
            rightIndex--;
        }
        return maximumPairSum;
    }

    public static void main(String[] args) {
        MinimizeMaximumPairSumInArray minimizeMaximumPairSumInArray = new MinimizeMaximumPairSumInArray();
        System.out.println(minimizeMaximumPairSumInArray.minPairSum(new int[] { 3, 5, 2, 3 }));
    }
}
