package com.leetcode.medium;

import java.util.TreeMap;

public class ContinuousSubArrays {
    public long continuousSubarrays(int[] nums) {
        long res = 0;
        int n = nums.length;
        var sorted_map = new TreeMap<Integer, Integer>();

        for (int end = 0, start = 0; end < n; end++) {
            // add current element to the map
            sorted_map.put(nums[end], sorted_map.getOrDefault(nums[end], 0) + 1);

            // when window violets the condition max_element_in_window -
            // min_element_in_window >2
            // shrink the window from left
            while (sorted_map.lastKey() - sorted_map.firstKey() > 2) {
                sorted_map.put(nums[start], sorted_map.get(nums[start]) - 1);
                sorted_map.remove(nums[start], 0);
                start++;
            }
            

            res += end - start + 1;
        }

        return res;
    }
}
