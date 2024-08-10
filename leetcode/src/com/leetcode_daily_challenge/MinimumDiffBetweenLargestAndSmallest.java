package com.leetcode_daily_challenge;

import java.util.Arrays;

public class MinimumDiffBetweenLargestAndSmallest {
    public int minDifference(int[] nums) {
        /*
         * min difference should be possible following cases
         * 1. kill three biggest elements (convert them into 4th biggest)
         * 2. kill two biggest and one smallest
         * 3. kill one biggest and two smallest
         * 4. kill three smallest
         * we need to take minDiff of all these cases
         */
        int n = nums.length, minDiff = Integer.MAX_VALUE;
        if (n < 5) {
            return 0;
        }
        Arrays.sort(nums);
        int curDiff = 0;
        for (int i = 0; i < 4; i++) {
            curDiff = nums[n - 4 + i] - nums[i];
            minDiff = Math.min(minDiff, curDiff);
        }
        return minDiff;
    }
}
