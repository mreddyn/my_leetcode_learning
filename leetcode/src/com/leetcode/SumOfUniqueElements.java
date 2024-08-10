package com.leetcode;

public class SumOfUniqueElements {
    private int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        int uniqueElementsSum = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                uniqueElementsSum += i;
            }
        }
        return uniqueElementsSum;
    }

    public static void main(String[] args) {
        SumOfUniqueElements s = new SumOfUniqueElements();
        int[] nums = { 1, 2, 3, 2 };
        System.out.println(s.sumOfUnique(nums));
    }
}
