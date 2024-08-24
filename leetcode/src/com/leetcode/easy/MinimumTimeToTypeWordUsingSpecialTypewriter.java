package com.leetcode.easy;

public class MinimumTimeToTypeWordUsingSpecialTypewriter {
    public int minTimeToType(String word) {
        /*
         * Initialize the prev as a;
         * Traverse the word, for each character, compute the distances from current
         * character, cur, to previous one, prev, clockwise and counter-clockwise,
         * respectively; Choose the minimum between them;
         * Count in 1 second for each typing character; therefore we can initialize cnt
         * to word.length().
         */
        int n = word.length(), time = n;
        char prev = 'a';
        for (int i = 0; i < n; i++) {
            char cur = word.charAt(i);
            int clockwiseDiff = Math.abs(cur - prev);
            int antiClockwiseDiff = Math.abs(26 - clockwiseDiff);
            int minDiff = Math.min(clockwiseDiff, antiClockwiseDiff);
            time += minDiff;
            prev = cur;
        }

        return time;
    }

    public static void main(String[] args) {
        MinimumTimeToTypeWordUsingSpecialTypewriter mTypewriter = new MinimumTimeToTypeWordUsingSpecialTypewriter();
        System.out.println(mTypewriter.minTimeToType("abc"));
        System.out.println(mTypewriter.minTimeToType("bza"));
        System.out.println(mTypewriter.minTimeToType("zjpc"));

    }
}
