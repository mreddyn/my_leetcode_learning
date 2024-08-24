package com.leetcode.easy;

public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        /*
         * Find the last house with different color of the first house.
         * Find the first house with different color of the last house.
         * Return the max distance of these two options.
         */
        int maxDistanceOfDiffHouses = 0, n = colors.length, left = 0, right = n - 1;

        // last house different from first house
        while (colors[0] == colors[right]) {
            right--;
        }

        // first house different from last house
        while (colors[left] == colors[n - 1]) {
            left++;
        }

        maxDistanceOfDiffHouses = Math.max(n - 1 - left, right);
        return maxDistanceOfDiffHouses;
    }
}
