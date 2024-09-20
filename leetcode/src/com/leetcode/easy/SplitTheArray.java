package com.leetcode.easy;

public class SplitTheArray {
    public boolean isPossibleToSplit(int[] nums) {
        /*
         * From the example we can the return false when a number occurs more than
         * twice.
         * since nums.length is always even it is always possible to split the array
         * into two
         * when there are only distinct and duplicate numbers.
         */
        int n = nums.length;
        int[] count = new int[101];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        for (int i = 0; i < 101; i++) {
            if (count[i] > 2) {
                return false;
            }

        }

        return true;
    }
}
