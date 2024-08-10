package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        List<List<Integer>> result = new ArrayList<>();
        sequenceHelper(nums, 0, new ArrayList<>(), result);
        System.out.println(result);
        if (result.size() == 0) {
            return false;
        }
        return true;
    }

    public void sequenceHelper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == 3 && current.get(0) < current.get(2) && current.get(2) < current.get(1)) {
            result.add(current);
            System.out.println(current);
            return;
        }
        if (index == nums.length) {
            return;
        }
        sequenceHelper(nums, index + 1, current, result);
        current.add(nums[index]);
        sequenceHelper(nums, index + 1, current, result);
        current.remove(current.size() - 1);

    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, -4, -3 };
        OneThreeTwoPattern otp = new OneThreeTwoPattern();
        System.out.println(otp.find132pattern(nums));
    }
}
