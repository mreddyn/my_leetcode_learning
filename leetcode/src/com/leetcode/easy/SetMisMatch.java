package com.leetcode.easy;

public class SetMisMatch {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, expectedSum = 0, actualSum = 0, duplicatedNumber = 0;
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                duplicatedNumber = Math.abs(num);
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
            actualSum += Math.abs(num);
        }

        expectedSum = (n * (n + 1)) / 2;
        int missingNumber = expectedSum - (actualSum - duplicatedNumber);

        return new int[] { duplicatedNumber, missingNumber };
    }
}
