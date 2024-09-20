package com.company.microsoft.leetcode.medium;

public class MaximumEnergyBoostFromTwoDrinks {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long maxBoostFromA = 0, maxBoostFromB = 0;
        for (int i = 0; i < n; i++) {
            long curBoostFromA = Math.max(energyDrinkA[i] + maxBoostFromA, maxBoostFromB);
            long curBoostFromB = Math.max(energyDrinkB[i] + maxBoostFromB, maxBoostFromA);
            maxBoostFromA = curBoostFromA;
            maxBoostFromB = curBoostFromB;
        }

        return Math.max(maxBoostFromA, maxBoostFromB);
    }
}
