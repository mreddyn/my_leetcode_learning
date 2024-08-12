package com.oa.company.amazon;

import java.util.Arrays;

public class NetworkOptimization {

    public static long getMinDistance(int[] center, int[] destination) {
        // Sort both arrays
        Arrays.sort(center);
        Arrays.sort(destination);

        long totalLag = 0;

        // Calculate the minimum total lag
        for (int i = 0; i < center.length; i++) {
            totalLag += Math.abs(center[i] - destination[i]);
        }

        return totalLag;
    }

    public static void main(String[] args) {
        int[] center1 = { 1, 2, 2 };
        int[] destination1 = { 5, 2, 4 };
        System.out.println(getMinDistance(center1, destination1)); // Output: 6

        int[] center2 = { 3, 1, 6, 8, 9 };
        int[] destination2 = { 2, 3, 1, 7, 9 };
        System.out.println(getMinDistance(center2, destination2)); // Output: 5
    }
}
