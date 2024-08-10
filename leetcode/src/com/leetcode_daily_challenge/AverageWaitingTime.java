package com.leetcode_daily_challenge;

public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int totalCustomers = customers.length, mealPrepStartTime = customers[0][0], mealPrepEndTime = 0;
        double totalWaitingTime = 0.0;
        for (int[] customer : customers) {
            int customerArrivalTime = customer[0];
            int preparationTime = customer[1];
            mealPrepStartTime = Math.max(mealPrepStartTime, customerArrivalTime);
            mealPrepEndTime = mealPrepStartTime + preparationTime;
            totalWaitingTime += mealPrepEndTime - customerArrivalTime;
            mealPrepStartTime = mealPrepEndTime;
        }

        double averageWaitingTime = (double) (totalWaitingTime / totalCustomers);
        return averageWaitingTime;
    }
}
