package com.oa.company.amazon.second_time;

public class ComputeMinimumTotalDistance {
    public int getMinTotalDistance(int[] dist_centers) {
        int n = dist_centers.length;

        int[][] distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int median = dist_centers[(i + j) / 2];
                for (int k = i; k <= j; k++) {
                    distance[i][j] += Math.abs(dist_centers[k] - median);
                }
            }
        }

        int[][] dp = new int[n][3];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 3; j++) {
                if (i < j) {
                    dp[i][j] = 0;
                } else if (j == 1) {
                    dp[i][j] = distance[0][i];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + distance[k + 1][i]);
                    }
                }
            }
        }

        return dp[n - 1][2];
    }

    public static void main(String[] args) {
        ComputeMinimumTotalDistance obj = new ComputeMinimumTotalDistance();
        System.out.println(obj.getMinTotalDistance(new int[] { 1, 2, 3 }));
        System.out.println(obj.getMinTotalDistance(new int[] { 1, 6 }));
        System.out.println(obj.getMinTotalDistance(new int[] { 1, 2, 5, 6 }));
    }
}
