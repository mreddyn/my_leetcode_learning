package com.leetcode_daily_challenge;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        int moves = 0, n = nums.length;
        // given [3, 2, 1, 2, 1, 7] after sorting it becomes [1, 1, 2, 2, 3, 7]
        // iterate through the array and
        // if nums[i] == nums[i-1] then increment nums[i] => nums[i] = nums[i] + 1
        // if nums[i] < nums[i-1] then increment nums[i] => nums[i] = nums[i-1]+1
        Arrays.sort(nums);
        int curValue = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                curValue = nums[i];
                nums[i] = nums[i - 1] + 1;
                moves += nums[i] - curValue;
            }
        }
        return moves;
    }

    public int minIncrementForUniqueApproachTwo(int[] nums) {
        int moves = 0, n = nums.length, maxElement = 0;

        // find the max element of the nums array
        for (int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }

        // create a frequency count array
        int[] count = new int[maxElement + n];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        // Iterate through the array and make all values unique
        for (int i = 0; i < count.length; i++) {
            if (count[i] <= 1) {
                // if it is already unique then continue
                continue;
            }
            int duplicates = count[i] - 1;
            count[i + 1] += duplicates;
            count[i] = 1;
            moves += duplicates;
        }

        return moves;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique makeArrayUnique = new MinimumIncrementToMakeArrayUnique();
        System.out.println(makeArrayUnique.minIncrementForUnique(new int[] { 3, 2, 1, 2, 1, 7 }));
    }
}
