package com.leetcode_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {
    public boolean checkSubArraySum(int[] nums, int k) {
        int n = nums.length, prefixMod = 0;
        Map<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            if (modSeen.containsKey(prefixMod)) {
                // the subArray size should be grater than 1
                if (i - modSeen.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                modSeen.put(prefixMod, i);
            }

        }

        return false;
    }
}
