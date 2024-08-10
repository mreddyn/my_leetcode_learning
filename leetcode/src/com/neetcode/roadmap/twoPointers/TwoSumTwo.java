package com.neetcode.roadmap.twoPointers;

public class TwoSumTwo {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int numOne = numbers[left];
            int numTwo = numbers[right];
            int sum = numOne + numTwo;
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { 0 };
    }
}
