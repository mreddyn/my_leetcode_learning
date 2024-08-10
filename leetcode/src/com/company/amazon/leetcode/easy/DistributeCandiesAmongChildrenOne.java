package com.company.amazon.leetcode.easy;

public class DistributeCandiesAmongChildrenOne {
    public int distributeCandiesBruteForce(int n, int limit) {
        /*
         * Use three loops(each loop goes only so far up to limit) to check for number
         * of ways
         * by checking the sum if equals n
         */
        int totalWays = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                for (int k = 0; k <= limit; k++) {
                    if (i + j + k == n) {
                        totalWays++;
                    }
                }
            }
        }
        return totalWays;
    }

    public int distributeCandiesOptimized(int n, int limit) {
        int totalWays = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= Math.min(limit - i, n - i); j++) {
                int twoChildrenCandies = i + j;
                if ((n - twoChildrenCandies) <= limit) {
                    totalWays++;
                }
            }
        }
        return totalWays;
    }
}
