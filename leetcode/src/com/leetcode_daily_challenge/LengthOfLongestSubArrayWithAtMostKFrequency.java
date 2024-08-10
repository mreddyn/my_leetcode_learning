package com.leetcode_daily_challenge;

import java.util.HashMap;

public class LengthOfLongestSubArrayWithAtMostKFrequency {
    /*
     * Explanation
     * Use a hashmap count to count the frequency of elements.
     * If an element has frequency bigger than k,
     * reduce the left side of window until it's not.
     * Then update the size of longest good subArray.
     * 
     */
    private static int maxSubArrayLength(int[] nums, int k) {
        int subArrayMaxLength = 0, n = nums.length;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int windowEnd, windowStart = 0, subArrayCurLength = 0;
        for (windowEnd = 0; windowEnd < n; windowEnd++) {
            int key = nums[windowEnd];
            frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
            while (frequencyMap.get(key) > k) {
                frequencyMap.put(nums[windowStart], frequencyMap.get(nums[windowStart++]) - 1);
            }
            subArrayCurLength = windowEnd - windowStart + 1;
            subArrayMaxLength = Math.max(subArrayCurLength, subArrayMaxLength);
        }

        return subArrayMaxLength;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayLength(new int[] { 1, 2, 2, 2 }, 1));
    }
}
