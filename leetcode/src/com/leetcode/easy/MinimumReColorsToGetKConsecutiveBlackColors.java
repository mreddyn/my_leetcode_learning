package com.leetcode.easy;

public class MinimumReColorsToGetKConsecutiveBlackColors {
    public int minimumRecolors(String blocks, int k) {
        /*
         * maintain a sliding window of size k, for each window count the number of
         * white blocks.
         * The number of white blocks represents the recolor count to paint them in
         * order to convert them to k consecutive black blocks.
         * 
         */
        int recolorCount, n = blocks.length();
        int windowEnd = k, windowStart = 0, wColorBlockCountInWindow = 0;
        for (int i = windowStart; i < windowEnd; i++) {
            if (blocks.charAt(i) == 'W') {
                wColorBlockCountInWindow++;
            }
        }

        recolorCount = wColorBlockCountInWindow;
        while (windowEnd < n) {
            if (blocks.charAt(windowEnd) == 'W') {
                wColorBlockCountInWindow++;
            }
            if (blocks.charAt(windowStart) == 'W') {
                wColorBlockCountInWindow--;
            }

            windowEnd++;
            windowStart++;
            recolorCount = Math.min(recolorCount, wColorBlockCountInWindow);
        }

        return recolorCount;
    }
}
