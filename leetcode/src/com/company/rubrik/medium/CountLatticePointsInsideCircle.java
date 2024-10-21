package com.company.rubrik.medium;

import java.util.HashSet;

public class CountLatticePointsInsideCircle {

    public int countLatticePoints(int[][] circles) {
        /*
         * calculate the distance between the point and the center of the circle using
         * the distance formula; if that distance is less than the radius of the circle,
         * then the point lies inside the circle; otherwise, it lies outside
         */
        // set to keep track of seen points
        var seen = new HashSet<String>();

        for (int[] circle : circles) {
            int x = circle[0], y = circle[1], r = circle[2];
            // generate integers for x-values in [x-r, x+r]
            for (int i = x - r; i <= x + r; i++) {
                // generate integers for y-values in [y-r, y+r]
                for (int j = y - r; j <= y + r; j++) {
                    if (isLatticePoint(x, y, r, i, j)) {
                        seen.add(i + "," + j);
                    }
                }
            }
        }

        return seen.size();
    }

    private boolean isLatticePoint(int x, int y, int r, int x1, int y1) {
        return ((x - x1) * (x - x1) + (y - y1) * (y - y1)) <= (r * r);
    }
}
