package com.leetcode.easy;

public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        /*
         * For the points to form a straight line their slopes should be equal.
         * We will calculate the slope of first two points and compare it slopes of the
         * rest of the points.
         */
        if (coordinates.length == 1) {
            return true;
        }
        int[] firstCoordinate = coordinates[0];
        int[] secondCoordinate = coordinates[1];
        int xDelta = getXXDiff(firstCoordinate, secondCoordinate);
        int yDelta = getYYDiff(firstCoordinate, secondCoordinate);
        for (int i = 2; i < coordinates.length; i++) {
            firstCoordinate = coordinates[0];
            secondCoordinate = coordinates[i];
            if (xDelta * getYYDiff(firstCoordinate, secondCoordinate) != yDelta
                    * getXXDiff(firstCoordinate, secondCoordinate)) {
                return false;
            }
        }

        return true;
    }

    private int getXXDiff(int[] firstCoordinate, int[] secondCoordinate) {
        return secondCoordinate[0] - firstCoordinate[0];
    }

    private int getYYDiff(int[] firstCoordinate, int[] secondCoordinate) {
        return secondCoordinate[1] - firstCoordinate[1];
    }
}
