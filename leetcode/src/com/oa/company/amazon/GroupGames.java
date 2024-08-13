package com.oa.company.amazon;

public class GroupGames {
    public static int countGamesWonByGroup1(int n, int[] group1, int[] group2) {
        final int MOD = 1000000007;
        long wins = 0;

        // Iterate over all pairs of players (i, j) in both groups
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate the sum for both groups
                int sumGroup1 = group1[i] + group1[j];
                int sumGroup2 = group2[i] + group2[j];

                // Check if group1's sum is greater than group2's sum
                if (sumGroup1 > sumGroup2) {
                    wins++;
                    if (wins >= MOD) {
                        wins %= MOD;
                    }
                }
            }
        }

        return (int) wins;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] group1 = { 1, 2, 3 };
        int[] group2 = { 3, 2, 1 };

        int result = countGamesWonByGroup1(n, group1, group2);
        System.out.println(result); // Output: 1
    }
}
