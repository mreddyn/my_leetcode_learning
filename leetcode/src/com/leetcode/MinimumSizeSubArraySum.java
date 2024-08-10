package com.leetcode;

public class MinimumSizeSubArraySum {
    private int minSubArrayLen(int target, int[] nums) {
        int minSizeSubArraySize = Integer.MAX_VALUE, n = nums.length, windowEnd, windowStart = 0, windowSum = 0;
        for (windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += nums[windowEnd];
            while (windowSum >= target) {
                minSizeSubArraySize = Math.min(minSizeSubArraySize, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return minSizeSubArraySize == Integer.MAX_VALUE ? 0 : minSizeSubArraySize;
    }

    public static void main(String[] args) {
        MinimumSizeSubArraySum minimumSizeSubArraySum = new MinimumSizeSubArraySum();
        System.out.println(minimumSizeSubArraySum.minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1, }));
    }
}
