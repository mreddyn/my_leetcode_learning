package com.leetcode_contest.contest_417;

public class FindTheKthCharacterInStringGameOne {
    public char kthCharacter(int k) {
        var sb = new StringBuilder();
        sb.append('a');
        while (sb.length() < k) {
            int n = sb.length();
            for (int i = 0; i < n; i++) {
                char c = sb.charAt(i);
                sb.append(++c);
            }
        }
        return sb.charAt(k - 1);
    }

    public char kthCharacterApproachTwo(int k) {
        /*
         * Intuition
         * Update k -= 1, we want to find s[k].
         * 
         * Consider k in binary format:
         * s[1xxx] is generated from s[xxx],
         * s[1xxx] = s[xxx] + 1
         * 
         * 
         * Explanation
         * Each bit means it's incremented once.
         * 
         * s[k] = s[0] + bits_count(k)
         * 
         * Just return bit count of k.
         */
        return (char) ('a' + Integer.bitCount(k - 1));
    }
}
