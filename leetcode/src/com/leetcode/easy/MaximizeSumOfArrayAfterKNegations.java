package com.leetcode.easy;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        /*
         * To obtain a max sum of array we need to turn negative integers into positive.
         * So if the given array has negative we will apply negations on them.
         * If the given array has no negative numbers then see if it contains zero,
         * because
         * negation of zero is still zero.
         * If given array has no negative integers and zeros then apply negations on
         * smallest positive integer.
         */
        int maxSum = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (k <= 0) {
                break;
            }
            int num = nums[i];

            if (num == 0) {
                // any number of negations can be applied to zero and it will still be zero.
                k = 0;
                break;
            } else if (num < 0) {
                // if a number is negative to maximize the sum, we need to make it positive
                nums[i] = -1 * num;
                k--;
            } else {
                // if k is even then applying k negations on a positive integer will result in
                // same number
                if (k % 2 == 0) {
                    k = 0;
                    break;
                }
                // if a number is positive to maximize it we need to keep it positive.
                // since the current number is positive it means we exhausted all negative
                // integers.
                // so we can apply all negations by choosing smallest of two numbers (current
                // number or previous number)

                if (i == 0) {
                    // first integer is positive, no negative integers or zero is present in nums
                    nums[i] = -1 * num;
                    k = 0;
                    break;
                } else {
                    if (nums[i] > nums[i - 1]) {
                        nums[i - 1] = -1 * nums[i - 1];
                    } else {
                        nums[i] = -1 * nums[i];
                    }
                    k = 0;
                    break;
                }

            }
        }

        // edge case (if all numbers are negative and we made them all positive but k >
        // 0)
        // then apply negations on last element in nums
        if (k > 0) {
            int sign = (k % 2 == 0) ? 1 : -1;
            nums[n - 1] = sign * nums[n - 1];
        }

        // calculate sum
        for (int i = 0; i < n; i++) {
            maxSum += nums[i];
        }

        return maxSum;
    }

    public int largestSumAfterKNegationsApproachTwo(int[] nums, int k) {
        /*
         * 1- sort the numbers in ascending order
         * 2- flip all the negative numbers, as long as k > 0
         * 3- find the sum of the new array (with flipped numbers if any) and keep track
         * of the minimum number
         * 4- Now for the return statement
         * 
         * res is the total sum of the new array
         * K % 2 check if the remaining K is odd.
         * 
         * Because if it's even, it will have no effect
         * (we will flip a number and then get it back to the original)
         * 
         * If it's odd,
         * flip the minimum number and remove twice its value from the result
         * (twice because we already added it as positive in our sum operation)
         */
        int maxSum = 0, n = nums.length, minVal = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -1 * nums[i];
                k--;
            }
        }

        for (int i = 0; i < n; i++) {
            maxSum += nums[i];
            minVal = Math.min(minVal, nums[i]);
        }

        if (k % 2 == 0) {
            return maxSum;
        }

        maxSum = maxSum - (2 * minVal);

        return maxSum;
    }

    public static void main(String[] args) {
        MaximizeSumOfArrayAfterKNegations mKNegations = new MaximizeSumOfArrayAfterKNegations();
        System.out.println(mKNegations.largestSumAfterKNegations(new int[] { 2, -3, -1, 5, -4 }, 2));
        System.out.println(mKNegations.largestSumAfterKNegations(new int[] { 4, 2, 3 }, 1));
        System.out.println(mKNegations.largestSumAfterKNegations(new int[] { 3, -1, 0, 2 }, 3));
        System.out.println(mKNegations.largestSumAfterKNegations(new int[] { -4, -2, -3 }, 4));
    }
}
