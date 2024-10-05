package com.leetcode.medium;

public class AlternatingGroupsTwo {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int alternatingGroupsCount = 0, n = colors.length, alternativeColorCount = 1, lastColor = colors[0];
        for (int i = 1; i < n; i++) {
            // if current color is different than last color then increase the count
            if (colors[i] != lastColor) {
                alternativeColorCount++;
            } else {
                alternativeColorCount = 1;
            }

            if (alternativeColorCount >= k) {
                // if the count is of k size then increment the group count
                alternatingGroupsCount++;
            }

            lastColor = colors[i];
        }

        for (int i = 0; i < k - 1; i++) {
            // since the array is treated as circular we need to count the last group
            if (colors[i] != lastColor) {
                alternativeColorCount++;
            } else {
                alternativeColorCount = 1;
            }

            if (alternativeColorCount >= k) {
                alternatingGroupsCount++;
            }

            lastColor = colors[i];
        }

        return alternatingGroupsCount;
    }
}
