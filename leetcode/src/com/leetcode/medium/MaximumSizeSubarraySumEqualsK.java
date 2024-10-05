package com.leetcode.medium;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        /*
         * for nums = [1,-1,5,-2,3]
         * prefixSums = [1,0,5,3,6]
         * 
         * if there exists some subarray from i to j summing to k in nums, then we know
         * that
         * prefixSum[j] - prefixSum[i] = k
         * prefixSum[j] - prefixSum[i] - k = 0
         * prefixSum[j] - k = prefixSum[i]
         */
        int longestSubarray = 0, n = nums.length, prefixSum = 0;
        var indices = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            // check if all the numbers seen so far sum to k
            if (prefixSum == k) {
                longestSubarray = i + 1;
            }

            // if any subarray seen so far sums to k, then
            // update the length of the longestSubarray
            if (indices.containsKey(prefixSum - k)) {
                longestSubarray = Math.max(longestSubarray, i - indices.get(prefixSum - k));
            }

            // only add the current prefixSum index pair to the map
            if (!indices.containsKey(prefixSum)) {
                indices.put(prefixSum, i);
            }
        }

        return longestSubarray;
    }
}
