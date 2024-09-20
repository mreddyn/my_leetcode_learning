package com.company.microsoft.leetcode.medium;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int minArrowShots = 1, n = points.length;
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));

        int end = points[0][1];
        for (int i = 1; i < n; i++) {
            if (points[i][0] >= end) {
                end = points[i][1];
                minArrowShots++;
            }
        }

        return minArrowShots;
    }
}
