package com.oa.company.everlaw;

public class FindMissingNumber {
    public int findMissingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        // xor all elements in the array
        for (int num : nums) {
            xor ^= num;
        }

        // xor all elements from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        return xor;
    }

    // For testing purposes
    public static void main(String[] args) {
        FindMissingNumber solution = new FindMissingNumber();
        int[] nums = { 3, 0, 1 };
        System.out.println(solution.findMissingNumber(nums)); // Expected 2
        int[] nums1 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(solution.findMissingNumber(nums1)); // Expected 8
    }
}
