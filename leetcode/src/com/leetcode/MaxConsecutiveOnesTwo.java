package com.leetcode;

public class MaxConsecutiveOnesTwo {
    private int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0, n = nums.length, windowEnd, windowStart = 0, zeroesCount = 0;
        for (windowEnd = 0; windowEnd < n; windowEnd++) {
            if (nums[windowEnd] == 0) {
                zeroesCount++;
            }
            if (zeroesCount <= 1) {
                maxOnes = Math.max(maxOnes, windowEnd - windowStart + 1);
            }
            while (zeroesCount > 1) {
                if (nums[windowStart] == 0) {
                    zeroesCount--;
                }
                windowStart++;
            }
        }

        return maxOnes;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesTwo maxConsecutiveOnesTwo = new MaxConsecutiveOnesTwo();
        System.out.println(maxConsecutiveOnesTwo.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));
    }
}
