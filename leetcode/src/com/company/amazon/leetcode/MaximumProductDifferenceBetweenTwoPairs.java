package com.company.amazon.leetcode;

import java.util.Arrays;

public class MaximumProductDifferenceBetweenTwoPairs {
    private int maxProductDifference(int[] nums) {
        int maxProductDiff = Integer.MIN_VALUE, size = nums.length;
        Arrays.sort(nums);
        maxProductDiff = (nums[size - 1] * nums[size - 2]) - (nums[0] * nums[1]);
        return maxProductDiff;
    }

    public static void main(String[] args) {
        MaximumProductDifferenceBetweenTwoPairs maximumProductDifferenceBetweenTwoPairs = new MaximumProductDifferenceBetweenTwoPairs();
        System.out.println(maximumProductDifferenceBetweenTwoPairs.maxProductDifference(new int[] { 5, 6, 2, 7, 4 }));
    }
}
