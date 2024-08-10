package com.leetcode;

public class RectangleOverlap {
    private boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean rec1RightOfRec2 = rec1[0] >= rec2[2];
        boolean rec2RightOfRec1 = rec2[0] >= rec1[2];
        boolean rec1TopOfRec2 = rec1[1] >= rec2[3];
        boolean rec2TopOfRec1 = rec2[1] >= rec1[3];
        return !(rec1RightOfRec2 || rec2RightOfRec1 || rec1TopOfRec2 || rec2TopOfRec1);
    }

    public static void main(String[] args) {
        RectangleOverlap rectangleOverlap = new RectangleOverlap();
        rectangleOverlap.isRectangleOverlap(null, null);
    }
}
