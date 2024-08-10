package com.leetcode;

import java.util.HashSet;

public class SingleNumber {
    private int singleNumber(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (seen.contains(nums[i])) {
                seen.remove(nums[i]);
                continue;
            }
            seen.add(nums[i]);
        }
        int number = seen.iterator().next();
        return number;
    }

    private int singleNumberApproachTwo(int[] nums) {
        /*
         * if you perform xor on same number then the result is zero, a^a=0
         */
        int n = nums.length, xorValue = 0;
        for(int i=0;i<n;i++) {
            xorValue ^= nums[i];
        }
        return xorValue;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[] { 4, 1, 2, 1, 2 }));
        System.out.println(singleNumber.singleNumberApproachTwo(new int[] { 4, 1, 2, 1, 2 }));
    }
}
