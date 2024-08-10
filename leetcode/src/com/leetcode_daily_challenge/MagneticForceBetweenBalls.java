package com.leetcode_daily_challenge;

import java.util.Arrays;

public class MagneticForceBetweenBalls {
    public int maxDistance(int[] position, int m) {
        int requiredForce = 0, n = position.length;
        Arrays.sort(position);

        // do binary search with mid as distance
        int left = 0, right;
        right = (int) Math.ceil(position[n - 1] / m - 1.0);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceBalls(position, m, mid)) {
                requiredForce = mid;
                // discard left search space since we can do better
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return requiredForce;
    }

    private boolean canPlaceBalls(int[] position, int m, int distance) {
        /*
         * check if we can place m balls int0 positions (buckets) with distance among
         * them
         */
        int previousBallPosition = position[0], ballsPlaced = 1;
        for (int i = 1; i < position.length && ballsPlaced < m; i++) {
            int currentBallPosition = position[i];
            if (currentBallPosition - previousBallPosition >= distance) {
                ballsPlaced++;
                previousBallPosition = currentBallPosition;
            }
        }

        return ballsPlaced == m;
    }
}
