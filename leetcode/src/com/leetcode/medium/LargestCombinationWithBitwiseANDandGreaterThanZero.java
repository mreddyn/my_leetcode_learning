package com.leetcode.medium;

public class LargestCombinationWithBitwiseANDandGreaterThanZero {
    public int largestCombination(int[] candidates) {
        /*
         * The longest combination will be given by the numbers that have 1 on the same
         * position.
         * Use an int[24] count to count the position of 1s of each number;
         * Return the max count of a position
         */
        int count = 0;
        var bitCount = new int[24];
        for (int candidate : candidates) {
            int index = 0;
            while (candidate > 0) {
                bitCount[index++] += (candidate & 1);
                candidate >>= 1;
            }
        }

        for (int i = 0; i < 24; i++) {
            count = Math.max(count, bitCount[i]);
        }

        return count;
    }
}
