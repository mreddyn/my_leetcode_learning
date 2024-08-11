package com.oa.company.amazon;

import java.util.Arrays;

public class SuitableWarehouseLocations {
    public int suitableLocations(int[] center, long d) {
        int locations = 0, n = center.length;
        Arrays.sort(center);

        // Binary Search for minimum and maximum suitable x
        int low = center[0], high = center[n - 1];

        int leftLimit = binarySearch(center, d, low, high, true);
        int rightLimit = binarySearch(center, d, low, high, false);

        // if no suitable locations then return 0
        if (leftLimit == -1 || rightLimit == -1 || leftLimit > rightLimit) {
            return locations;
        }

        locations = rightLimit - leftLimit + 1;

        return locations;
    }

    private int binarySearch(int[] center, long d, int low, int high, boolean findLeft) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalDistance = calculateTotalDistance(center, mid);
            if (totalDistance <= d) {
                result = mid;
                if (findLeft) {
                    high = mid - 1; // Look for a smaller x
                } else {
                    low = mid + 1; // Look for a larger x
                }
            } else {
                if (findLeft) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }

    private long calculateTotalDistance(int[] center, int x) {
        long totalDistance = 0;
        for (int pos : center) {
            totalDistance += Math.abs(pos - x);
        }
        return totalDistance;
    }

    public static void main(String[] args) {
        SuitableWarehouseLocations sLocations = new SuitableWarehouseLocations();
        System.out.println(sLocations.suitableLocations(new int[] { 2, 0, 3, -4 }, 22));
    }
}
