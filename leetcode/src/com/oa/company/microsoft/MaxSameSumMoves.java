package com.oa.company.microsoft;

import java.util.*;

public class MaxSameSumMoves {

    // We'll store -1 in dp[l][r] to denote "uncomputed".
    // dp[l][r] = maximum # of moves using subarray A[l...r], with each move summing
    // to 'targetSum'.
    static int[][] dp;

    // Top-down memoized DFS
    private static int solveSubproblem(int[] A, int l, int r, int targetSum) {
        // If fewer than 2 elements remain, no move possible
        if (r - l + 1 < 2)
            return 0;
        // Already computed?
        if (dp[l][r] != -1)
            return dp[l][r];

        int best = 0;
        // 1) Remove first two if they sum to targetSum
        if (A[l] + A[l + 1] == targetSum) {
            best = Math.max(best, 1 + solveSubproblem(A, l + 2, r, targetSum));
        }
        // 2) Remove last two if they sum to targetSum
        if (A[r - 1] + A[r] == targetSum) {
            best = Math.max(best, 1 + solveSubproblem(A, l, r - 2, targetSum));
        }
        // 3) Remove first and last if they sum to targetSum
        if (A[l] + A[r] == targetSum) {
            best = Math.max(best, 1 + solveSubproblem(A, l + 1, r - 1, targetSum));
        }

        dp[l][r] = best;
        return best;
    }

    // For a given target sum S, compute the maximum number of moves possible.
    private static int solveForSum(int[] A, int S) {
        int n = A.length;
        // Reset dp array for this particular sum
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        // Solve subproblem on the entire array
        return solveSubproblem(A, 0, n - 1, S);
    }

    // Main solver: enumerates all candidate sums and picks the best
    public static int maxMovesWithSameSum(int[] A) {
        int n = A.length;
        if (n < 2) {
            return 0; // can't make any move if fewer than 2 elements
        }

        // Collect all possible sums from pairs in A
        Set<Integer> possibleSums = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                possibleSums.add(A[i] + A[j]);
            }
        }

        int ans = 0;
        // For each candidate sum, compute best possible moves
        for (int sum : possibleSums) {
            int moves = solveForSum(A, sum);
            ans = Math.max(ans, moves);
        }
        return ans;
    }

    // Demo main
    public static void main(String[] args) {
        // You could replace this with code that reads N and array A from standard
        // input.

        // Example 1:
        int[] A1 = { 3, 1, 5, 3, 3, 4, 2 };
        System.out.println(maxMovesWithSameSum(A1)); // Expected: 3

        // Example 2:
        int[] A2 = { 4, 1, 4, 3, 3, 2, 5, 2 };
        System.out.println(maxMovesWithSameSum(A2)); // Expected: 4

        // Example 3:
        int[] A3 = { 1, 9, 1, 1, 1, 1, 1, 1, 8, 1 };
        System.out.println(maxMovesWithSameSum(A3)); // Expected: 1

        // Example 4:
        int[] A4 = { 1, 9, 8, 9, 5, 1, 2 };
        System.out.println(maxMovesWithSameSum(A4)); // Expected: 3

        // Example 5:
        int[] A5 = { 1, 1, 2, 3, 1, 2, 2, 1, 1, 2 };
        System.out.println(maxMovesWithSameSum(A5)); // Expected: 4
    }
}
