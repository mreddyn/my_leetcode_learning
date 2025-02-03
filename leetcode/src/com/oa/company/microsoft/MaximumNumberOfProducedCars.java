package com.oa.company.microsoft;

import java.util.Arrays;

public class MaximumNumberOfProducedCars {
    public static int solution(int[] H, int X, int Y) {
        Arrays.sort(H);
        int N = H.length;
        int[] prefixSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + H[i];
        }
        boolean[] dp = new boolean[X + 1];
        dp[0] = true;
        int maxCount = 0;
        for (int k = 1; k <= N; k++) {
            int current = H[k - 1];
            for (int x = X; x >= current; x--) {
                if (dp[x - current]) {
                    dp[x] = true;
                }
            }
            int sum = prefixSum[k];
            if (sum > X + Y) {
                continue;
            }
            int lower = Math.max(sum - Y, 0);
            int upper = Math.min(X, sum);
            boolean found = false;
            for (int x = lower; x <= upper; x++) {
                if (dp[x]) {
                    found = true;
                    break;
                }
            }
            if (found) {
                maxCount = k;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        // Example 1
        int[] H1 = { 1, 1, 3 };
        int X1 = 1, Y1 = 1;
        System.out.println(solution(H1, X1, Y1)); // Expected 2

        // Example 2
        int[] H2 = { 6, 5, 5, 4, 3 };
        int X2 = 8, Y2 = 9;
        System.out.println(solution(H2, X2, Y2)); // Expected 4

        // Example 3
        int[] H3 = { 6, 5, 2, 1, 8 };
        int X3 = 17, Y3 = 5;
        System.out.println(solution(H3, X3, Y3)); // Expected 5

        // Example 4
        int[] H4 = { 5, 5, 4, 6 };
        int X4 = 8, Y4 = 8;
        System.out.println(solution(H4, X4, Y4)); // Expected 2
    }
}
