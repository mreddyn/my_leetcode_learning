package com.leetcode.easy;

public class FindTheMiddleIndexInArray {
    public int findMiddleIndex(int[] nums) {
        /*
         * calculate prefixSum and suffixSum for the given array.
         * Iterate through the prefixSum and suffixSum arrays from right to left.
         * Whenever at an index prefixSum[i] == suffixSum[i] record it.
         * finally return this index.
         */
        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        suffixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        int middleIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (prefixSum[i] == suffixSum[i]) {
                middleIndex = i;
            }
        }

        return middleIndex;
    }

    public int findMiddleIndexApproachTwo(int[] nums) {
        int n = nums.length, totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        int suffixSum = 0, middleIndex = -1;
        for (int i = n - 1; i >= 0; i--) {

            if (suffixSum + nums[i] == (totalSum - suffixSum)) {
                middleIndex = i;
            }
            suffixSum += nums[i];
        }

        return middleIndex;
    }
}
