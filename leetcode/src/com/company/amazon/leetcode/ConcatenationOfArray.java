package com.company.amazon.leetcode;

public class ConcatenationOfArray {
    private int[] getConcatenation(int[] nums) {
        int size = nums.length, ansIndex = 0;
        int[] ans = new int[2 * size];
        for (int i = 0; i < size; i++) {
            ans[ansIndex] = nums[i];
            ans[ansIndex + size] = nums[i];
            ansIndex++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ConcatenationOfArray concatenationOfArray = new ConcatenationOfArray();
        System.out.println(concatenationOfArray.getConcatenation(new int[] { 1, 2, 3 }));
    }
}
