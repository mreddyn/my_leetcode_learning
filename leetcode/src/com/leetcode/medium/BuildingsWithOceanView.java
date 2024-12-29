package com.leetcode.medium;

import java.util.ArrayDeque;

public class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        var stack = new ArrayDeque<Integer>();
        int greatest = -1, n = heights.length;

        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > greatest) {
                stack.push(heights[i]);
            }
            greatest = Math.max(greatest, heights[i]);
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}
