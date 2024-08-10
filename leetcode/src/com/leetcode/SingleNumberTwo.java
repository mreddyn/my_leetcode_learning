package com.leetcode;

import java.util.HashSet;

public class SingleNumberTwo {
    private int singleNumber(int[] nums) {
        HashSet<Integer> nums_set = new HashSet<>();
        int n = nums.length;
        long sumOfNums = 0, sumOfNumsSet = 0;
        for (int i = 0; i < n; i++) {
            sumOfNums += nums[i];
            if (!nums_set.contains(nums[i])) {
                nums_set.add(nums[i]);
                sumOfNumsSet += nums[i];
            }
        }
        return (int) (((3 * sumOfNumsSet) - sumOfNums) / 2);
    }

    public static void main(String[] args) {
        SingleNumberTwo singleNumberTwo = new SingleNumberTwo();
        System.out.println(singleNumberTwo.singleNumber(new int[] { 2, 3, 2, 3, 2, 3, 4 }));
    }
}
