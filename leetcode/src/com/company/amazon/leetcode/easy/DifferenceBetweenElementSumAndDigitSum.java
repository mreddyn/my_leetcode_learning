package com.company.amazon.leetcode.easy;

public class DifferenceBetweenElementSumAndDigitSum {
    public int differenceOfSum(int[] nums) {
        int diff = 0, elementSum = 0, digitSum = 0;
        elementSum = sumOfAllElements(nums);
        digitSum = digitSumOfAllElements(nums);
        diff = Math.abs(elementSum - digitSum);
        return diff;
    }

    private int sumOfAllElements(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private int digitSumOfAllElements(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            while (num > 0) {
                sum += (num % 10);
                num = num / 10;
            }
        }
        return sum;
    }
}
