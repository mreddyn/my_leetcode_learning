package com.leetcode.medium;

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        /*
         * When a > 0, then the parabola is in first and second quadrant
         * else it is in third and fourth quadrant
         */
        int n = nums.length;
        var result = new int[n];
        int index = (a > 0) ? n - 1 : 0;
        int left = 0, right = n - 1;
        if (a > 0) {
            while (left <= right) {
                int leftQuad = quad(nums[left], a, b, c);
                int rightQuad = quad(nums[right], a, b, c);
                if (leftQuad > rightQuad) {
                    result[index--] = leftQuad;
                    left++;
                } else {
                    result[index--] = rightQuad;
                    right--;
                }
            }
        } else {
            while (left <= right) {
                int leftQuad = quad(nums[left], a, b, c);
                int rightQuad = quad(nums[right], a, b, c);
                if (leftQuad < rightQuad) {
                    result[index++] = leftQuad;
                    left++;
                } else {
                    result[index++] = rightQuad;
                    right--;
                }
            }
        }
        return result;
    }

    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
