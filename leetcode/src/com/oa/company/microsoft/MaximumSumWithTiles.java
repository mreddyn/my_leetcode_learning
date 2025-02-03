package com.oa.company.microsoft;

public class MaximumSumWithTiles {
    public int microsoftSumWithTiles(int[] A) {
        int n = A.length;
        if (n < 2) {
            return 0;
        }

        var B = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            B[i] = A[i] + A[i + 1];
        }

        /*
         * “Select up to 3 elements from
         * 𝐵
         * B such that no two selected elements are adjacent, and the sum of the
         * selected elements is maximized.”
         */
        var dp = new int[n][4];

        for (int i = 1; i < n; i++) {
            for (int k = 1; k < 4; k++) {

                // case 1: don't pick B[i]
                int notPick = dp[i - 1][k];

                // Case 2: pick B[i-1], skip the adjacent B[i-2]
                // We can do this only if i-2 >= 0 and k-1 >= 0
                int pick = B[i - 1];
                int previousIndex = i - 2;

                if (previousIndex >= 0 && k - 1 >= 0) {
                    pick += dp[previousIndex][k - 1];
                }

                dp[i][k] = Math.max(notPick, pick);
            }
        }

        return dp[n - 1][3];
    }

    public static void main(String[] args) {
        MaximumSumWithTiles obj = new MaximumSumWithTiles();

        // Example 1
        int[] A1 = { 2, 3, 5, 2, 3, 4, 6, 4, 1 };
        System.out.println(obj.microsoftSumWithTiles(A1)); // should be 25

        // Example 2
        int[] A2 = { 1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1 };
        System.out.println(obj.microsoftSumWithTiles(A2)); // should be 35

        // Example 3
        int[] A3 = { 1, 2, 3, 3, 2 };
        System.out.println(obj.microsoftSumWithTiles(A3)); // should be 10

        // Example 4
        int[] A4 = { 5, 10, 3 };
        System.out.println(obj.microsoftSumWithTiles(A4)); // should be 15

        // Edge case: N=1
        int[] A5 = { 7 };
        System.out.println(obj.microsoftSumWithTiles(A5)); // can't place a tile => 0
    }
}
