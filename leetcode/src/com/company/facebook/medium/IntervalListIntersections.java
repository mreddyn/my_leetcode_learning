package com.company.facebook.medium;

import java.util.ArrayList;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstPointer = 0, secondPointer = 0;
        var intersectionList = new ArrayList<int[]>();
        while (firstPointer < firstList.length && secondPointer < secondList.length) {
            int first_start = firstList[firstPointer][0], first_end = firstList[firstPointer][1];
            int second_start = secondList[secondPointer][0], second_end = secondList[secondPointer][1];

            if (first_start <= second_end && second_start <= first_end) {
                // there is overlap
                int intersection_start = Math.max(first_start, second_start);
                int intersection_end = Math.min(first_end, second_end);
                intersectionList.add(new int[] { intersection_start, intersection_end });
            }

            if (first_end <= second_end) {
                // we exhausted first list, so increment it
                firstPointer++;
            } else {
                secondPointer++;
            }
        }

        return intersectionList.toArray(new int[0][]);
    }
}
