package com.oa.company.tiktok;

public class CircularPurchases {
    // https://leetcode.com/discuss/interview-question/4728444/Tiktok-OA-Hard-SDE

    public static int countPurchases(int[] costs, long budget) {
        int n = costs.length;
        int totalPurchases = 0;

        // Calculate the minimum cost in the array
        int minCost = Integer.MAX_VALUE;
        for (int cost : costs) {
            minCost = Math.min(minCost, cost);
        }

        while (budget >= minCost) {
            long currentBudget = budget;
            int currentPurchases = 0;

            for (int i = 0; i < n; i++) {
                if (costs[i] <= currentBudget) {
                    currentBudget -= costs[i];
                    currentPurchases++;
                }
            }

            totalPurchases += currentPurchases;
            budget = currentBudget;
        }

        return totalPurchases;
    }

    public static void main(String[] args) {
        int[] costs1 = { 5, 8, 3 };
        long budget1 = 12;
        System.out.println(countPurchases(costs1, budget1)); // Output: 3

        int[] costs2 = { 2, 4, 100, 2, 6 };
        long budget2 = 21;
        System.out.println(countPurchases(costs2, budget2)); // Output: 6

        int[] costs3 = { 2, 2, 7, 5 };
        long budget3 = 15;
        System.out.println(countPurchases(costs3, budget3)); // Output: 5
    }
}
