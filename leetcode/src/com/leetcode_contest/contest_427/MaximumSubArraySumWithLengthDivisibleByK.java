package com.leetcode_contest.contest_427;

import java.util.Arrays;

public class MaximumSubArraySumWithLengthDivisibleByK {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        var prefixSum = new long[n + 1];
        // calculate prefix sums
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // Initialize array to track min prefix sums for each remainder.
        // Use a large positive value initially.
        long[] minPrefixSumForRemainder = new long[k];
        Arrays.fill(minPrefixSumForRemainder, Long.MAX_VALUE);

        // for remainder 0 we consider prefixSum 0
        minPrefixSumForRemainder[0] = 0;

        long max_subarray_sum = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int remainder = i % k;

            // If we have encountered this remainder before,
            // we can try to form a subarray ending at i-1.
            if (minPrefixSumForRemainder[remainder] != Long.MAX_VALUE) {
                long subarray_sum = prefixSum[i] - minPrefixSumForRemainder[remainder];
                max_subarray_sum = Math.max(max_subarray_sum, subarray_sum);
            }

            // Update the minimum prefix sum for this remainder if needed.
            if (prefixSum[i] < minPrefixSumForRemainder[remainder]) {
                minPrefixSumForRemainder[remainder] = prefixSum[i];
            }
        }

        return max_subarray_sum;
    }
}
