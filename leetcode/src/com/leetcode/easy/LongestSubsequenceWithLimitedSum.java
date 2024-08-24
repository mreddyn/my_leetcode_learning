package com.leetcode.easy;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        /*
         * Since we only care about the sum and not the order, we can just sort the nums
         * and calculate prefixSum.
         * Finally for each query we can just do binary search the sum.
         */
        int[] answer = new int[queries.length];
        int n = nums.length, sum = 0;
        Arrays.sort(nums);
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        for (int i = 0; i < queries.length; i++) {
            // binary search to find the sum <= query in prefixSum
            answer[i] = binarySearch(prefixSum, queries[i]);
        }

        return answer;
    }

    private int binarySearch(int[] prefixSum, int target) {
        int left = 0, right = prefixSum.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (prefixSum[mid] == target) {
                return mid + 1;
            }
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
