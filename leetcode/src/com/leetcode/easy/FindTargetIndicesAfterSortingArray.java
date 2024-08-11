package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        /*
         * Maintain two variables count and lessThanTarget.
         * count variable tracks how many numbers are equal to target.
         * lessThanTarget variable tracks how many numbers are less than target.
         * by iterating through nums array we increment two variables.
         * 
         * The index for target starts after lessThanTarget until count iterations.
         */
        int count = 0, lessThanTarget = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            } else if (num < target) {
                lessThanTarget++;
            }
        }
        List<Integer> targetIndicesList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            targetIndicesList.add(lessThanTarget++);
        }
        return targetIndicesList;
    }
}
