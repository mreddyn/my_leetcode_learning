package com.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

public class MaximumFrequencyOfAnElementAfterOperationsOne {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxPossibleFreq = 1, n = nums.length;

        // sort the nums in non-decreasing order
        Arrays.sort(nums);

        // insert the elements into Hashmap to keep track of frequencies
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // case 1: choosing an existing number as reference point
        int left = 0, right = 0;
        for (int mid = 0; mid < n; mid++) {
            // Move the left pointer to maintain that the difference between nums[mid] and
            // nums[left] is <= k
            while (nums[mid] - nums[left] > k) {
                left++;
            }

            // Move the right pointer to maintain that the difference between nums[right]
            // and nums[mid] is <= k
            while (right < n - 1 && nums[right + 1] - nums[mid] <= k) {
                right++;
            }

            // total elements in the current range
            int count = right - left + 1;

            // now convert count-map.get(nums[mid]) numbers to nums[mid] so that we get
            // maxFreq
            int possibleFreq = Math.min(count - map.get(nums[mid]), numOperations) + map.get(nums[mid]);
            maxPossibleFreq = Math.max(maxPossibleFreq, possibleFreq);

        }

        // case 2: choosing some number which does not exist in nums as reference point
        // We calculate this midpoint as (nums[left] + nums[right]) / 2 and adjust left
        // so that the midpoint is within k distance from both nums[left] and
        // nums[right]. This ensures all elements between left and right can potentially
        // be modified to match this midpoint.
        left = 0;
        for (right = 0; right < n; right++) {
            int mid = (nums[left] + nums[right]) / 2;

            // move the left pointer until the mid-pointer falls within range [nums[left],
            // nums[right]]
            while (mid - nums[left] > k || nums[right] - mid > k) {
                left++;
                mid = (nums[left] + nums[right]) / 2;
            }
            maxPossibleFreq = Math.max(maxPossibleFreq, Math.min(right - left + 1, numOperations));
        }

        return maxPossibleFreq;
    }
}
