package com.leetcode;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    private int maximumCount(int[] nums) {
        int maxCountOfPositiveAndNegative = 0, positiveIntegersCount = 0, negativeIntegersCount = 0;
        // search for numbers that are greater than or equal to 1 to get positive
        // integers count to get the lower bound
        // search for number 0 to get the lower bound
        positiveIntegersCount = nums.length - binarySearch(nums, 1);
        negativeIntegersCount = binarySearch(nums, 0);
        System.out.println(positiveIntegersCount + " " + negativeIntegersCount);
        maxCountOfPositiveAndNegative = Math.max(positiveIntegersCount, negativeIntegersCount);
        return maxCountOfPositiveAndNegative;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("left " + left);
        return left;
    }

    public static void main(String[] args) {
        MaximumCountOfPositiveIntegerAndNegativeInteger mAndNegativeInteger = new MaximumCountOfPositiveIntegerAndNegativeInteger();
        System.out.println(mAndNegativeInteger.maximumCount(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }));
    }
}
