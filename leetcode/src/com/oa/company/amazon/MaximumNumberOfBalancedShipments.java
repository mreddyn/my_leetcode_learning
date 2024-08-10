package com.oa.company.amazon;

public class MaximumNumberOfBalancedShipments {
    public int maxNumberOfBalancedShipments(int[] weights) {
        // write your code here
        int n = weights.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            int max = Integer.MIN_VALUE;
            dp[i][1] = -1;
            for (int j = i - 1; j >= 0; j--) {
                max = Math.max(max, weights[j]);
                if (dp[j][0] >= 0 && max > weights[i]) {
                    dp[i][1] = dp[j][0] + 1;
                    break;
                }
            }
        }
        return dp[n - 1][1];
    }
}
