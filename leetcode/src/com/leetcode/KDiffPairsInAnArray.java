package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        int pairsCount = 0, n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = 1;
        while (left < n && right < n) {
            int diff = nums[right] - nums[left];
            if (left == right || diff > k) {
                left++;
            } else if (diff < k) {
                right++;
            } else {
                left++;
                pairsCount++;
                while (left < n && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
        return pairsCount;
    }

    public int findPairsApproachTwo(int[] nums, int k) {
        int n = nums.length, pairsCount = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int element = entry.getKey();
            int value = entry.getValue();
            if (k > 0 && freqMap.containsKey(element + k)) {
                pairsCount++;
            } else if (k == 0 && value > 1) {
                pairsCount++;
            }
        }
        return pairsCount;
    }
}
