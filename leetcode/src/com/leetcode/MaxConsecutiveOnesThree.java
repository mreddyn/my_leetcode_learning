package com.leetcode;

public class MaxConsecutiveOnesThree {
    private int longestOnes(int[] nums, int k) {
        int maxOnes = 0, n = nums.length, windowEnd, windowStart = 0, zeroesCount = 0;
        for (windowEnd = 0; windowEnd < n; windowEnd++) {
            if (nums[windowEnd] == 0) {
                zeroesCount++;
            }
            if (zeroesCount <= k) {
                maxOnes = Math.max(maxOnes, windowEnd - windowStart + 1);
            }
            while (zeroesCount > k) {
                if (nums[windowStart] == 0) {
                    zeroesCount--;
                }
                windowStart++;
            }
        }

        return maxOnes;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesThree maxConsecutiveOnesThree = new MaxConsecutiveOnesThree();
        System.out.println(maxConsecutiveOnesThree.longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
    }
}
