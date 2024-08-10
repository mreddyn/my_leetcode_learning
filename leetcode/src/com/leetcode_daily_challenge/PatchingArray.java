package com.leetcode_daily_challenge;

import java.util.Arrays;

public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        int minPatches = 0, size = nums.length;
        Arrays.sort(nums);
        long currentMax = 0;
        int index = 0;
        while (currentMax < n) {
            if (index < size && nums[index] <= currentMax + 1) {
                currentMax += nums[index];
                index++;
            } else {
                currentMax += currentMax + 1;
                minPatches++;
            }
        }

        return minPatches;
    }
}
