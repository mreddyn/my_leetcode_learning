package com.leetcode_daily_challenge;

public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrinkableBottles = numBottles;
        while (numBottles >= numExchange) {
            int remainder = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            totalDrinkableBottles += numBottles;
            numBottles += remainder;
        }
        return totalDrinkableBottles;
    }
}
