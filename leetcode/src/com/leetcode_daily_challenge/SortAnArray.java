package com.leetcode_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        int minVal = nums[0], maxVal = nums[0];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (int i = minVal; i <= maxVal; i++) {
            if (freqMap.containsKey(i)) {
                while (freqMap.get(i) > 0) {
                    nums[index++] = i;
                    freqMap.put(i, freqMap.get(i) - 1);
                }
            }
        }

        return nums;
    }
}
