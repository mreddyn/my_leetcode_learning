package com.company.microsoft.leetcode.easy;

public class CountHillAndValleysInArray {
    public int countHillValley(int[] nums) {
        /*
         * remove the adjacent duplicates by converting them to zeroes and moving to end
         * of array.
         * Then calculate hills and valleys by checking immediate neighbors for an
         * element at index i.
         */
        int hillsAndValleysCount = 0;
        int nonZeroIndexEnd = removeAdjacentDuplicates(nums);
        for (int i = 1; i < nonZeroIndexEnd; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                hillsAndValleysCount++;
            } else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                hillsAndValleysCount++;
            }
        }

        return hillsAndValleysCount;
    }

    private int removeAdjacentDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i - 1] = 0;
            }
        }

        int nonZeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }

        return nonZeroIndex;
    }

    public int countHillValleyApproachTwo(int[] nums) {
        /*
         * Maintain two pointers (i and j), i to check if there is a hill or valley
         * and j to increment only when there is a hill or valley
         */
        int hillsAndValleysCount = 0;
        for (int i = 1, j = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[j] && nums[i] > nums[i + 1]) {
                hillsAndValleysCount++;
                j = i;
            } else if (nums[i] < nums[j] && nums[i] < nums[i + 1]) {
                hillsAndValleysCount++;
                j = i;
            }

        }
        return hillsAndValleysCount;
    }
}
