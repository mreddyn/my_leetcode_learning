package com.leetcode.easy;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        /*
         * Maintain a window of size k which starts from index 1 to k when k > 0.
         * if k < 0 then window starts from n-k to n-1
         */
        int n = code.length;
        int decrypted[] = new int[n];
        if (k == 0) {
            return decrypted;
        }
        int windowStart = 1, windowEnd = k, windowSum = 0;
        if (k < 0) {
            k = -k;
            windowStart = n - k;
            windowEnd = n - 1;
        }

        for (int i = windowStart; i <= windowEnd; i++) {
            // initial windowSum
            windowSum += code[i];
        }

        for (int i = 0; i < n; i++) {
            // Iterate through the array and move window by one-index
            decrypted[i] = windowSum;
            windowSum -= code[(windowStart++) % n];
            windowSum += code[(++windowEnd) % n];
        }
        return decrypted;
    }
}
