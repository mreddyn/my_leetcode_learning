package com.oa.company.microsoft;

import java.util.*;

public class MinDominoRemovals {

    /**
     * Given an array A of length 2*N, representing N domino tiles (A[2K], A[2K+1]),
     * returns the minimum number of tiles that must be removed so that
     * the remaining tiles form a correct domino sequence.
     */
    public static int minRemovals(int[] A) {
        int N = A.length / 2; // Number of domino tiles

        // dp[i] = length of the longest correct domino subsequence ending with domino i
        int[] dp = new int[N];
        Arrays.fill(dp, 1); // each tile can be a subsequence of length 1 by itself

        int maxChainLength = 1; // track the best chain overall

        for (int i = 0; i < N; i++) {
            // i-th domino has left = A[2*i], right = A[2*i + 1]
            int leftI = A[2 * i];

            // Check all previous dominoes j < i
            for (int j = 0; j < i; j++) {
                int rightJ = A[2 * j + 1];

                // Condition: The right side of j must match the left side of i
                if (rightJ == leftI) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxChainLength = Math.max(maxChainLength, dp[i]);
        }

        // Minimum to remove = total dominoes - length of longest valid subsequence
        return N - maxChainLength;
    }

    // Demo usage with the provided examples
    public static void main(String[] args) {
        // Example 1:
        int[] A1 = { 2, 4, 1, 3, 4, 6, 2, 4, 1, 6 }; // (2,4), (1,3), (4,6), (2,4), (1,6)
        System.out.println(minRemovals(A1)); // Expected 3

        // Example 2:
        // Provided: [5, 1, 2, 6, 6, 1, 3, 1, 4, 3, 4, 6, 1, 2, 4, 1, 6, 21]
        // = 9 dominoes. The example states the answer is 7.
        int[] A2 = { 5, 1, 2, 6, 6, 1, 3, 1, 4, 3, 4, 6, 1, 2, 4, 1, 6, 21 };
        System.out.println(minRemovals(A2)); // Expected 7

        // Example 3:
        int[] A3 = { 1, 5, 3, 3, 1, 31 }; // (1,5), (3,3), (1,31)
        // No two adjacent can match at the boundary (without flipping),
        // so the longest chain is just 1 domino by itself.
        // N=3 => remove 2
        System.out.println(minRemovals(A3)); // Expected 2
    }
}
