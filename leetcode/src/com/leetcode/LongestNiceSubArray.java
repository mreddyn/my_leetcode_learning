package com.leetcode;

public class LongestNiceSubArray {
    private int longestNiceSubArray(int[] nums) {
        int longestSubArray = 0, n = nums.length, windowStart = 0, windowEnd = 0;
        int xorTotal = 0, sumTotal = 0;
        // for two numbers a, b if a&b = 0 then a^b == a+b
        while (windowEnd < n) {
            xorTotal = xorTotal ^ nums[windowEnd];
            sumTotal = sumTotal + nums[windowEnd];
            while (xorTotal != sumTotal) {
                xorTotal = xorTotal ^ nums[windowStart];
                sumTotal = sumTotal - nums[windowStart];
                windowStart++;
            }
            longestSubArray = Math.max(longestSubArray, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return longestSubArray;
    }

    public static void main(String[] args) {
        LongestNiceSubArray longestNiceSubArray = new LongestNiceSubArray();
        System.out.println(longestNiceSubArray.longestNiceSubArray(new int[] { 3, 1, 5, 11, 13 }));
    }
}
