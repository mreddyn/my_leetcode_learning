package com.oa.company.microsoft;

public class CarProduction {
    public static int solution(int[] H, int X, int Y) {
        // dp[x][y] = max number of cars that can be produced
        // using x hours on line 1 and y hours on line 2
        int[][] dp = new int[X + 1][Y + 1];

        // Process each car
        for (int h : H) {
            // We'll update in descending order to avoid using updated states within this
            // same car iteration
            for (int x = X; x >= 0; x--) {
                for (int y = Y; y >= 0; y--) {
                    if (dp[x][y] >= 0) {
                        // Try putting car h on line 1 (if it fits)
                        if (x + h <= X) {
                            dp[x + h][y] = Math.max(dp[x + h][y], dp[x][y] + 1);
                        }
                        // Try putting car h on line 2 (if it fits)
                        if (y + h <= Y) {
                            dp[x][y + h] = Math.max(dp[x][y + h], dp[x][y] + 1);
                        }
                    }
                }
            }
        }

        // Find the global maximum in dp
        int maxCars = 0;
        for (int x = 0; x <= X; x++) {
            for (int y = 0; y <= Y; y++) {
                maxCars = Math.max(maxCars, dp[x][y]);
            }
        }

        return maxCars;
    }

    // Example usage
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
