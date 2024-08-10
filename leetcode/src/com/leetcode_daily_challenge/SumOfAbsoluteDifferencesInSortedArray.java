package com.leetcode_daily_challenge;

public class SumOfAbsoluteDifferencesInSortedArray {
    private int[] getSumAbsoluteDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum[i] - nums[i];
            int rightSum = prefixSum[n - 1] - prefixSum[i];

            int leftCount = i;
            int rightCount = n - i - 1;

            int leftTotal = leftCount * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];
            result[i] = leftTotal + rightTotal;
        }

        return result;
    }

    public static void main(String[] args) {
        SumOfAbsoluteDifferencesInSortedArray sumOfAbsoluteDifferencesInSortedArray = new SumOfAbsoluteDifferencesInSortedArray();
        int[] nums = { 2, 3, 5 };
        int[] result = sumOfAbsoluteDifferencesInSortedArray.getSumAbsoluteDifference(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
