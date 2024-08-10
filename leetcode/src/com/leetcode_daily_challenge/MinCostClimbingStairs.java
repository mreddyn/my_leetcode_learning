package com.leetcode_daily_challenge;

public class MinCostClimbingStairs {
    private int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        for (int index = 2; index < cost.length; index++) {
            cost[index] += Math.min(cost[index - 1], cost[index - 2]);
        }

        int topFloorCost = Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        return topFloorCost;
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
    }
}
