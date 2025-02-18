package com.company.rubrik.medium;

import java.util.Random;

public class RandomPickIndex {
    private int[] nums;
    private Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int count = 0, result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }

            if (random.nextInt(++count) == 0) {
                result = i;
            }
        }
        return result;
    }
}
