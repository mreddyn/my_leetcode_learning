package com.leetcode.easy;

public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        for (int i = 1; i < points.length; i++) {
            int[] firstPoint = points[i - 1];
            int[] secondPoint = points[i];
            int xDiff = getXDiff(firstPoint, secondPoint);
            int yDiff = getYDiff(firstPoint, secondPoint);
            int timeTaken = Math.max(xDiff, yDiff);
            minTime += timeTaken;
        }
        return minTime;
    }

    private int getXDiff(int[] firstPoint, int[] secondPoint) {
        return Math.abs(secondPoint[0] - firstPoint[0]);
    }

    private int getYDiff(int[] firstPoint, int[] secondPoint) {
        return Math.abs(secondPoint[1] - firstPoint[1]);
    }
}
