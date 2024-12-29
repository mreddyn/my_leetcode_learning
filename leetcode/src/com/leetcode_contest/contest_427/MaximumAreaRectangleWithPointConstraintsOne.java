package com.leetcode_contest.contest_427;

import java.util.HashSet;

public class MaximumAreaRectangleWithPointConstraintsOne {
    public int maxRectangleArea(int[][] points) {
        /*
         * Insert all points into a HashSet for O(1) lookups.
         * Iterate over all pairs of points to identify potential rectangles.
         * Since edges must be parallel to the axes, any rectangle is determined by
         * selecting two distinct x-coordinates and two distinct y-coordinates.
         * For instance, if you pick two points (x1, y1) and (x2, y2), and if x1 != x2
         * and y1 != y2, these might be the diagonally opposite corners of a rectangle.
         * Check if (x1, y2) and (x2, y1) are also in the set.
         * Once a rectangle’s four corners are identified, ensure no other points are
         * inside or on the border.
         * Compute x_min, x_max, y_min, y_max.
         * Check all points to ensure no point lies in the rectangle except the four
         * corners.
         * Keep track of the maximum area found.
         * If no valid rectangle is found, return -1.
         */
        // insert all points into set for quick checks
        var pointSet = new HashSet<String>();
        for (var point : points) {
            pointSet.add(point[0] + "," + point[1]);
        }

        int n = points.length, maxArea = -1;

        // Iterate over all points to find to find two points of a diagonal
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                // we need distinct points to form a diagonal
                if (x1 == x2 || y1 == y2) {
                    continue;
                }

                // now we have diagonal points (x1, y1), (x2, y2)
                // we will check points for other diagonal (x1, y2) , (x2, y1)
                String corner3 = x1 + "," + y2;
                String corner4 = x2 + "," + y1;
                if (pointSet.contains(corner3) && pointSet.contains(corner4)) {
                    // now we identified four points to form a rectangle.
                    // now we will check if no other point is on or in the rectangle
                    int xMin = Math.min(x1, x2);
                    int xMax = Math.max(x1, x2);
                    int yMin = Math.min(y1, y2);
                    int yMax = Math.max(y1, y2);

                    if (noExtraPointInside(points, xMin, xMax, yMin, yMax, pointSet)) {
                        int area = (xMax - xMin) * (yMax - yMin);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }

        return maxArea;
    }

    private boolean noExtraPointInside(int[][] points, int xMin, int xMax, int yMin, int yMax,
            HashSet<String> pointSet) {
        // rectangle corners
        var c1 = xMin + "," + yMin;
        var c2 = xMin + "," + yMax;
        var c3 = xMax + "," + yMin;
        var c4 = xMax + "," + yMax;

        for (var point : points) {
            int x = point[0];
            int y = point[1];

            if (x >= xMin && x <= xMax && y >= yMin && y <= yMax) {
                var s = x + "," + y;
                if (!s.equals(c1) && !s.equals(c2) && !s.equals(c3) && !s.equals(c4)) {
                    return false;
                }
            }
        }
        return true;
    }
}
