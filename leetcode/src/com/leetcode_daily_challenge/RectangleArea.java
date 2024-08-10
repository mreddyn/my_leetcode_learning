package com.leetcode_daily_challenge;

public class RectangleArea {
    private static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        /*
         * 1. Get area of first rectangle
         * 2. Get area of second rectangle
         * 3. Find common area of two rectangles
         * 4. Add both area of two rectangles and subtract common area
         */
        int firstRectangleArea, secondRectangleArea, commonArea, totalArea, x_distance, y_distance;
        firstRectangleArea = Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1);
        secondRectangleArea = Math.abs(bx2 - bx1) * Math.abs(by2 - by1);
        x_distance = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        y_distance = Math.min(ay2, by2) - Math.max(ay1, by1);
        if (x_distance < 0 || y_distance < 0) {
            commonArea = 0;
        } else {
            commonArea = x_distance * y_distance;
        }
        totalArea = firstRectangleArea + secondRectangleArea - commonArea;
        return totalArea;
    }

    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        System.out.println(computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }
}
