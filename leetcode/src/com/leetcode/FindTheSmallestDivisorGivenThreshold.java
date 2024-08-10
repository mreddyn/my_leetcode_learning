package com.leetcode;

public class FindTheSmallestDivisorGivenThreshold {
    public int smallestDivisorBruteForce(int[] nums, int threshold) {
        int sum, left = 1, right = (int) 1e6;
        while (left < right) {
            int mid = (left + right) / 2;
            sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        FindTheSmallestDivisorGivenThreshold fDivisorGivenThreshold = new FindTheSmallestDivisorGivenThreshold();
        System.out.println(fDivisorGivenThreshold.smallestDivisorBruteForce(new int[] { 1, 2, 5, 9 }, 6));
    }
}
