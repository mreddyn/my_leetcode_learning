package com.leetcode.easy;

public class FindClosestNumber {
    public int findClosestNumber(int[] nums) {
        /*
         * At max there can be two numbers with least difference, one positive and one
         * negative.
         * In this case, the positive number has to be considered as the answer.
         */
        int closestNumberToZero = Integer.MAX_VALUE;
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(closestNumberToZero) || num == Math.abs(closestNumberToZero)) {
                closestNumberToZero = num;
            }
        }

        return closestNumberToZero;
    }
}
