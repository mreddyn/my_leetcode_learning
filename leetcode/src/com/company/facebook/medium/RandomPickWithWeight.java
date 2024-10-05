package com.company.facebook.medium;

public class RandomPickWithWeight {
    private int[] prefixSums;
    private int totalSum;

    public RandomPickWithWeight(int[] w) {
        int n = w.length;
        this.prefixSums = new int[n];
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += w[i];
            prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;

    }

    public int pickIndex() {
        double target = Math.random() * this.totalSum;

        // searching for the target zone by doing a linear search
        for (int index = 0; index < this.prefixSums.length; index++) {
            if (target < prefixSums[index]) {
                return index;
            }
        }

        return 0;
    }
}
