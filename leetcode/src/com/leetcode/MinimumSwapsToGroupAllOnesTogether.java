package com.leetcode;

public class MinimumSwapsToGroupAllOnesTogether {
    public int minSwaps(int[] data) {
        /*
         * Find max number of ones a window of size k (k = total number of ones in data
         * array)
         */
        int n = data.length, totalOnes = 0;
        for (int i = 0; i < n; i++) {
            totalOnes += data[i];
        }
        if (totalOnes == 0) {
            return 0;
        }

        int windowEnd = 0, windowStart = 0, maxOnesInWindow = 0, k = totalOnes, onesInWindow = 0;

        while (windowEnd < n) {
            onesInWindow += data[windowEnd++];

            while ((windowEnd - windowStart) > k) {
                onesInWindow -= data[windowStart++];
            }
            maxOnesInWindow = Math.max(maxOnesInWindow, onesInWindow);
        }
        return totalOnes - maxOnesInWindow;
    }

    public static void main(String[] args) {
        MinimumSwapsToGroupAllOnesTogether mAllOnesTogether = new MinimumSwapsToGroupAllOnesTogether();
        System.out.println(mAllOnesTogether.minSwaps(new int[] { 1, 0, 1, 0, 1 }));
    }
}
