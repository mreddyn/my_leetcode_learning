package com.oa.company.microsoft;

import java.util.Arrays;

public class FindMinimumCost {
    public static int minCost(int[] A, int X, int Y) {
        // Sort in descending order
        Arrays.sort(A);
        reverse(A); // so that A[0] is the largest

        int n = A.length;

        // Baseline: assign Type 1 (cost X) to all houses
        long cost = (long) n * X; // use long if n and X can be large
        long minCost = cost;

        // We'll use two pointers:
        // i goes from the front (largest) forward for "upgrades"
        // j goes from the back (smallest) backward for "removals"
        int j = n - 1;

        // Try upgrading houses from largest to smaller
        for (int i = 0; i < n; i++) {
            if (i > j) {
                // We've already removed or passed all smaller houses
                break;
            }

            // Cost change for upgrading house i from type1 -> type2
            cost += (Y - X);
            // Surplus coverage gained by this upgrade
            long surplus = A[i]; // because we go from coverage A[i] to 2*A[i]

            // Use the surplus to remove as many smallest houses as possible
            while (j > i && j >= 0 && surplus >= A[j]) {
                surplus -= A[j];
                cost -= X; // removing a type1 panel from house j
                j--;
            }

            // Track the best (lowest) cost found so far
            minCost = Math.min(minCost, cost);
        }

        return (int) minCost; // or return as long if needed
    }

    // Helper: reverse an array in-place
    private static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // A quick test
    public static void main(String[] args) {
        int[] A = { 4, 3, 5, 2 };
        int X = 2, Y = 5;
        System.out.println(minCost(A, X, Y)); // should print 7 (from the example)
    }
}
