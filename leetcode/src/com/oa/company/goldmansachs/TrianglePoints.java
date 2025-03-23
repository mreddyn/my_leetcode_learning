package com.oa.company.goldmansachs;

public class TrianglePoints {

    /**
     * Returns:
     * 0: If the triangle ABC is degenerate (not a valid triangle).
     * 1: If p is in the triangle, but q is not.
     * 2: If q is in the triangle, but p is not.
     * 3: If both p and q are in the triangle.
     * 4: If neither p nor q is in the triangle.
     */
    public static int pointsBelong(
            int x1, int y1,
            int x2, int y2,
            int x3, int y3,
            int xp, int yp,
            int xq, int yq) {

        // area2ABC = 2 * area of triangle ABC (absolute value)
        long area2ABC = area2(x1, y1, x2, y2, x3, y3);

        // Check if triangle is degenerate (area = 0).
        if (area2ABC == 0) {
            return 0; // Scenario 0
        }

        // Check if point p is inside or on the boundary of triangle ABC
        boolean pIn = isPointInTriangle(x1, y1, x2, y2, x3, y3, xp, yp, area2ABC);

        // Check if point q is inside or on the boundary of triangle ABC
        boolean qIn = isPointInTriangle(x1, y1, x2, y2, x3, y3, xq, yq, area2ABC);

        // Return the scenario based on pIn and qIn
        if (pIn && !qIn) {
            return 1;
        } else if (!pIn && qIn) {
            return 2;
        } else if (pIn && qIn) {
            return 3;
        } else {
            return 4;
        }
    }

    /**
     * area2(x1, y1, x2, y2, x3, y3) computes twice the signed area of
     * the triangle formed by points (x1,y1), (x2,y2), (x3,y3).
     * 
     * We take the absolute value so we only deal with positive areas.
     * Using long to avoid overflow in case coordinates are large.
     */
    private static long area2(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(
                (long) x1 * (y2 - y3)
                        + (long) x2 * (y3 - y1)
                        + (long) x3 * (y1 - y2));
    }

    /**
     * Determines whether the point (xp, yp) lies on or inside the triangle
     * ABC by comparing area2 sums:
     * 
     * area2(ABC) = area2(p, b, c) + area2(a, p, c) + area2(a, b, p).
     * 
     * If the sum of the three sub-triangle areas equals the area of ABC,
     * the point lies on or inside the triangle.
     */
    private static boolean isPointInTriangle(
            int x1, int y1, int x2, int y2, int x3, int y3,
            int xp, int yp,
            long area2ABC) {

        long areaPBC = area2(xp, yp, x2, y2, x3, y3);
        long areaAPC = area2(x1, y1, xp, yp, x3, y3);
        long areaABP = area2(x1, y1, x2, y2, xp, yp);

        long sumSubAreas = areaPBC + areaAPC + areaABP;
        return sumSubAreas == area2ABC;
    }

    // Example usage
    public static void main(String[] args) {
        // Example:
        // Triangle: A(0,0), B(5,0), C(2,5)
        // p = (2,2), q = (5,5)
        // See which scenario fits.
        int scenario = pointsBelong(0, 0, 5, 0, 2, 5, 2, 2, 5, 5);
        System.out.println("Scenario: " + scenario);
    }
}
