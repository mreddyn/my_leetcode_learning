package com.oa.company.wayfair;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int boxes = 0;

        for (var box : boxTypes) {
            if (truckSize >= box[0]) {
                boxes += box[0] * box[1];
                truckSize -= box[0];
            } else {
                boxes += truckSize * box[1];
                return boxes;
            }
        }

        return boxes;
    }
}
