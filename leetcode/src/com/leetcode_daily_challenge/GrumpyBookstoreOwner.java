package com.leetcode_daily_challenge;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxCustomersSatisfied = 0, n = customers.length;
        int windowStart = 0, windowEnd = 0, currentWindowUnsatisfiedCustomers = 0, maxUnsatisfiedCustomers = 0;
        while (windowEnd < n) {
            currentWindowUnsatisfiedCustomers += customers[windowEnd] * grumpy[windowEnd];
            if((windowEnd - windowStart + 1) >= minutes) {
                maxUnsatisfiedCustomers = Math.max(maxUnsatisfiedCustomers, currentWindowUnsatisfiedCustomers);
                currentWindowUnsatisfiedCustomers -= customers[windowStart] * grumpy[windowStart];
                windowStart++;
            }
            windowEnd++;
        }
        System.out.println("Unsatisfied customers " + maxUnsatisfiedCustomers);

        // Already satisfied customers (when the owner is not grumpy)
        int alreadySatisfiedCustomers = 0;
        for (int i = 0; i < n; i++) {
            alreadySatisfiedCustomers += (customers[i] * (1 - grumpy[i]));
        }
        maxCustomersSatisfied = alreadySatisfiedCustomers + maxUnsatisfiedCustomers;

        return maxCustomersSatisfied;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner gBookstoreOwner = new GrumpyBookstoreOwner();
        gBookstoreOwner.maxSatisfied(new int[] { 1, 0, 1, 2, 1, 1, 7, 5 }, new int[] { 0, 1, 0, 1, 0, 1, 0, 1 }, 3);
    }
}
