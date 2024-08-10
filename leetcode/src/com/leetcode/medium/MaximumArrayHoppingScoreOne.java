package com.leetcode.medium;

public class MaximumArrayHoppingScoreOne {
    public int maxScore(int[] nums) {
        /*
         * The best hop is the next highest value to the right side of current index or suffix.
         * We will start from last and try to hop whenever we encounter a max number
         * than the current one.
         */
        int maxHoppingScore = 0, n = nums.length, maxVal = 0, count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count++;
            if (nums[i] > maxVal) {
                maxHoppingScore += count * maxVal;
                maxVal = nums[i];
                count = 0;
            }
        }
        maxHoppingScore += count * maxVal;
        return maxHoppingScore;
    }
}
