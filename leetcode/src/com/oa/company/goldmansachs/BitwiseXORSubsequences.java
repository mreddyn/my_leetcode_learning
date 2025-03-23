package com.oa.company.goldmansachs;

import java.util.HashMap;

public class BitwiseXORSubsequences {
    public int maxSubsequenceLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        /*
         * since in the subsequence all the adjacent elements should match bitwise XOR
         * so the subsequence will look like this:
         * x, x^k, x, x^k, x, x^k..
         * because x^k^k = x
         * 
         * so we can use dynamic programming to solve this problem
         * 
         */

        int n = arr.length;
        // bestEndWith[i] stores the maximum length of subsequence ending with arr[i]
        var bestEndWith = new HashMap<Integer, Integer>();
        int maxLen = 0; // the maximum length of subsequence

        for (int i = 0; i < n; i++) {
            bestEndWith.put(arr[i], 1);
            /*
             * the only way to extend the subsequence ending with arr[i] is to find the
             * previous element
             * 
             */
            int newLength = bestEndWith.getOrDefault(arr[i] ^ k, 0) + 1;
            bestEndWith.put(arr[i], Math.max(bestEndWith.get(arr[i]), newLength));
            maxLen = Math.max(maxLen, bestEndWith.get(arr[i]));
        }

        return maxLen;
    }

    public static void main(String[] args) {
        BitwiseXORSubsequences obj = new BitwiseXORSubsequences();
        int[] arr = { 2, 1, 3, 5, 2 };
        int k = 2;
        System.out.println(obj.maxSubsequenceLength(arr, k)); // 2
    }
}
