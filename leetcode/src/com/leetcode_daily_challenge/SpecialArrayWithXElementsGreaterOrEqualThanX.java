package com.leetcode_daily_challenge;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterOrEqualThanX {
    private int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int candidate = nums.length - i;
            boolean condOne = candidate <= nums[i];
            boolean condTwo = (i - 1 < 0) || (candidate > nums[i - 1]);
            if (condOne && condTwo) {
                return candidate;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SpecialArrayWithXElementsGreaterOrEqualThanX sGreaterOrEqualThanX = new SpecialArrayWithXElementsGreaterOrEqualThanX();
        System.out.println(sGreaterOrEqualThanX.specialArray(new int[] { 3, 5 }));
    }
}
