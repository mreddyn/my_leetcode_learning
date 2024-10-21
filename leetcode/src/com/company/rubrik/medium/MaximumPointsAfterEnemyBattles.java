package com.company.rubrik.medium;

import java.util.Arrays;

public class MaximumPointsAfterEnemyBattles {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        /*
         * Sort the list of enemy energies in ascending order to prioritize defeating
         * enemies that require the least energy first, thereby maximizing early points
         * accumulation.
         * If the initial energy is insufficient to defeat the weakest enemy, return 0.
         * Otherwise, absorb energies from the strongest enemies at the right end of the
         * list, using this energy to defeat the weakest enemy multiple times and
         * maximize points. Decrement the right pointer as you continue absorbing energy
         * from the right.
         */
        int n = enemyEnergies.length;
        long maxPoints = 0;
        Arrays.sort(enemyEnergies);
        if (currentEnergy < enemyEnergies[0]) {
            // insufficient energy to start the match
            return maxPoints;
        }
        int enemyIndex = n - 1;
        while (enemyIndex >= 0) {
            if (currentEnergy >= enemyEnergies[0]) {
                maxPoints++;
                currentEnergy -= enemyEnergies[0];
            } else {
                currentEnergy += enemyEnergies[enemyIndex];
                enemyIndex--;
            }
        }

        return maxPoints;
    }

    public long maximumPointsApproachTwo(int[] enemyEnergies, int currentEnergy) {
        long maxPoints = 0, totalEnergy = currentEnergy;
        int smallestEnemyEnergy = Integer.MAX_VALUE;
        for (int enemyEnergy : enemyEnergies) {
            smallestEnemyEnergy = Math.min(smallestEnemyEnergy, enemyEnergy);
            totalEnergy += enemyEnergy;
        }

        if (currentEnergy < smallestEnemyEnergy) {
            // no way to defeat smallest enemy
            return maxPoints;
        }

        totalEnergy -= smallestEnemyEnergy;
        // number of times I am defeating smallest enemy
        maxPoints = totalEnergy / smallestEnemyEnergy;

        return maxPoints;
    }
}
