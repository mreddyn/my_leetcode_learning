package com.oa.company.amazon;

import java.util.Arrays;

public class ComputationallySameProcesses {

    public static long getPairsCount(int[] process, int k) {
        Arrays.sort(process); // Step 1: Sort the array

        long count = 0;
        int n = process.length;

        // Step 2: Two-pointer technique to count valid pairs
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && process[j] - process[i] <= k) {
                j++;
            }
            // All pairs (i, i+1), (i, i+2), ..., (i, j-1) are valid
            count += (j - i - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] process1 = { 100, 200, 300, 400 };
        int k1 = 250;
        System.out.println(getPairsCount(process1, k1)); // Output: 5

        int[] process2 = { 10, 12, 11 };
        int k2 = 0;
        System.out.println(getPairsCount(process2, k2)); // Output: 0

        int[] process3 = { 7, 10, 13, 11 };
        int k3 = 3;
        System.out.println(getPairsCount(process3, k3)); // Output: 4
    }
}
