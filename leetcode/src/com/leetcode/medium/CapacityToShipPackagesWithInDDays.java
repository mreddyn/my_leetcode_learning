package com.leetcode.medium;

public class CapacityToShipPackagesWithInDDays {
    public int shipWithinDays(int[] weights, int days) {

        // minCapacity will be the max weight in the weights array
        // maxCapacity will be total sum of weights
        int maxWeight = 0, totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        // we will check if we can ship all packages in given days with mid capacity or
        // not
        int left = maxWeight, right = totalWeight;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if we can ship all packages in mid capacity, then travel left
            // else right
            if (canShipWithTheCapacity(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canShipWithTheCapacity(int[] weights, int capacity, int days) {
        int totalWeight = 0, daysCount = 1; // days it takes to ship all packages with the capacity
        for (int weight : weights) {
            totalWeight += weight;
            if (totalWeight > capacity) {
                daysCount++;
                totalWeight = weight;
            }

            if (daysCount > days) {
                return false;
            }
        }

        return true;
    }
}
