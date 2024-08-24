package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        /*
         * Since individual lists are already sorted. Thus, we can consider only the
         * extreme points in the arrays to do the distance calculations.
         */
        int maxDistance = Integer.MIN_VALUE, size = arrays.size(), minVal, maxVal, firstListSize;
        firstListSize = arrays.get(0).size();
        minVal = arrays.get(0).get(0);
        maxVal = arrays.get(0).get(firstListSize - 1);
        for (int i = 1; i < size; i++) {
            int curListSize = arrays.get(i).size();
            maxDistance = Math.max(maxDistance, Math.abs(arrays.get(i).get(curListSize - 1) - minVal));
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - arrays.get(i).get(0)));
            minVal = Math.min(minVal, arrays.get(i).get(0));
            maxVal = Math.max(maxVal, arrays.get(i).get(curListSize - 1));
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        MaximumDistanceInArrays mArrays = new MaximumDistanceInArrays();
        List<Integer> firstList = Arrays.asList(1, 2, 3);
        List<Integer> secondList = Arrays.asList(1, 2);
        List<Integer> thirdList = Arrays.asList(0);
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(firstList);
        arrays.add(secondList);
        arrays.add(thirdList);
        mArrays.maxDistance(arrays);
    }
}
