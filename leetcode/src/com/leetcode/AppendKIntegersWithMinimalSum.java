package com.leetcode;

import java.util.Arrays;

public class AppendKIntegersWithMinimalSum {
    private long minimalSum(int[] nums, int k) {
        long sum = 0;
        int size = nums.length, missingIntegers = 1, numsIndex = 0;
        Arrays.sort(nums);
        while (numsIndex < size && k > 0) {

            if (missingIntegers == nums[numsIndex]) {
                missingIntegers++;
                numsIndex++;
            } else {
                if (missingIntegers > nums[numsIndex]) {
                    numsIndex++;
                } else {
                    sum += missingIntegers;
                    k--;
                    missingIntegers++;
                }
            }
        }
        while (k > 0) {
            sum += missingIntegers;
            missingIntegers++;
            k--;
        }

        return sum;
    }

    public static void main(String[] args) {
        AppendKIntegersWithMinimalSum appendKIntegersWithMinimalSum = new AppendKIntegersWithMinimalSum();
        System.out.println(appendKIntegersWithMinimalSum.minimalSum(new int[] { 1, 4, 4, 10, 25 }, 4));
    }
}
