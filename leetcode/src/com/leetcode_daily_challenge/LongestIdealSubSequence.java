package com.leetcode_daily_challenge;

public class LongestIdealSubSequence {
    private int longestIdealString(String s, int k) {
        int longestIdealStringLength = 1, n = s.length();
        // init an array to store longest ideal string ending at character 'c'
        int[] dp = new int[26];

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            /*
             * Iterate backwards from the current character index (idx) up to k positions
             * and forwards from idx up to k positions.
             * At each position, update dp[idx] with the maximum of its current value and
             * dp[j] + 1, where j is the position being iterated over.
             */
            for (int j = idx; j >= 0 && j >= idx - k; j--) {
                dp[idx] = Math.max(dp[idx], dp[j] + 1);
            }
            for (int j = idx + 1; j < 26 && j <= idx + k; j++) {
                dp[idx] = Math.max(dp[idx], dp[j] + 1);
            }
            longestIdealStringLength = Math.max(longestIdealStringLength, dp[idx]);
        }

        return longestIdealStringLength;
    }

    public static void main(String[] args) {
        LongestIdealSubSequence longestIdealSubSequence = new LongestIdealSubSequence();
        System.out.println(longestIdealSubSequence.longestIdealString("acfgbd", 2));
    }
}
