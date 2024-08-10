package com.leetcode;

import java.util.HashMap;

public class BrightestPositionOnStreet {
    private int brightestPosition(int[][] lights) {
        int smallestBrightestPosition = Integer.MAX_VALUE, brightestValue = Integer.MIN_VALUE;
        HashMap<Integer, Integer> positions = new HashMap<>();
        for (int[] light : lights) {
            int position = light[0];
            int range = light[1];
            int start = position - range;
            int end = position + range;
            for (int i = start; i <= end; i++) {
                positions.put(i, positions.getOrDefault(i, 0) + 1);
            }
        }
        for (int key : positions.keySet()) {
            int value = positions.get(key);
            if (value > brightestValue) {
                brightestValue = value;
                smallestBrightestPosition = key;
            } else if (value == brightestValue && smallestBrightestPosition > key) {
                smallestBrightestPosition = key;
            }
        }

        return smallestBrightestPosition;
    }

    public static void main(String[] args) {
        BrightestPositionOnStreet brightestPositionOnStreet = new BrightestPositionOnStreet();
        int[][] lights = { { -3, 2 }, { 1, 2 }, { 3, 3 } };
        System.out.println(brightestPositionOnStreet.brightestPosition(lights));
    }
}
