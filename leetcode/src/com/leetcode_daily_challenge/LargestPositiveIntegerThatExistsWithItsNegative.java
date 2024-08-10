package com.leetcode_daily_challenge;

import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    
    private int findMaxK(int[] nums) {
        int n = nums.length, largestPositive = Integer.MIN_VALUE, largestNegative = Integer.MAX_VALUE, maxValue = 0;
        int[] count = new int[2001];
        /*
         * store the integers in an array to represent the values on x-axis
         * keep track of maxValue
         */
        for (int i = 0; i < n; i++) {
            count[nums[i] + 1000]++;
            maxValue = Math.max(maxValue, nums[i]);
        }
        /*
         * start from middle (1000), and go front i-steps and back i-steps at a time
         * until maxValue.
         * if you encounter an integer exists in both, then update largestNegative and
         * largestPositive
         */
        int leftBound = 1000, rightBound = 1000;
        for (int i = 1; i <= maxValue; i++) {
            leftBound = 1000 - i;
            rightBound = 1000 + i;
            if (count[leftBound] > 0 && count[rightBound] > 0) {
                largestPositive = rightBound - 1000;
                largestNegative = leftBound - 1000;
            }
        }

        System.out.println(largestPositive + " " + largestNegative);
        return (largestPositive == -largestNegative) ? largestPositive : -1;
    }

    private int findMaxKAnotherApproach(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, sum = 0;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum == 0) {
                return nums[right];
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LargestPositiveIntegerThatExistsWithItsNegative lItsNegative = new LargestPositiveIntegerThatExistsWithItsNegative();
        System.out.println(lItsNegative.findMaxK(new int[] { -1, 10, 6, 7, -7, 1 }));
        System.out.println(lItsNegative.findMaxKAnotherApproach(new int[] { -1, 10, 6, 7, -7, 1 }));
    }
}
