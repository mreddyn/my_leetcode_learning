package com.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;

public class CountCompleteSubarraysInAnArray {
    public int countCompleteSubarrays(int[] nums) {
        /*
         * If we want any subarray or substring with exactly k integers or characters
         * then
         * we can find it by the formula
         * subarrays with at least k integers - subarrays with at least k-1 integers
         */
        int distinctElementsInWholeArray = 0;
        var distinctElementsSet = new HashSet<Integer>();
        for (int num : nums) {
            distinctElementsSet.add(num);
        }

        distinctElementsInWholeArray = distinctElementsSet.size();
        int completeSubarraysCount = subarraysWithAtLeastKDistinctIntegers(nums, distinctElementsInWholeArray)
                - subarraysWithAtLeastKDistinctIntegers(nums, distinctElementsInWholeArray - 1);

        return completeSubarraysCount;
    }

    private int subarraysWithAtLeastKDistinctIntegers(int[] nums, int k) {
        int subarraysCount = 0, n = nums.length;
        var map = new HashMap<Integer, Integer>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            map.put(nums[windowEnd], map.getOrDefault(nums[windowEnd], 0) + 1);
            while (map.size() > k) {
                map.put(nums[windowStart], map.get(nums[windowStart]) - 1);
                if (map.get(nums[windowStart]) == 0) {
                    map.remove(nums[windowStart]);
                }
                windowStart++;
            }

            subarraysCount += (windowEnd - windowStart + 1);
        }

        return subarraysCount;
    }
}
