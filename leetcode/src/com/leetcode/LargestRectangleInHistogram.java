package com.leetcode;

import java.util.Map;
import java.util.Stack;

public class LargestRectangleInHistogram {
    private int largestRectangleAreaBruteForce(int[] heights) {
        int maxRectangleArea = 0, size = heights.length;
        for (int i = 0; i < size; i++) {
            int minHeight = heights[i];
            for (int j = i; j < size; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int distance = j - i + 1;
                maxRectangleArea = Math.max(maxRectangleArea, minHeight * distance);
            }
        }
        return maxRectangleArea;
    }

    private int largestRectangleAreaApproachTwo(int[] heights) {
        int maxRectangleArea = 0, size = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < size; i++) {
            while (stack.peek() != -1 && (heights[stack.peek()] >= heights[i])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxRectangleArea = Math.max(maxRectangleArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = size - stack.peek() - 1;
            maxRectangleArea = Math.max(maxRectangleArea, currentHeight * currentWidth);
        }
        return maxRectangleArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleAreaBruteForce(new int[] { 2, 1, 5, 6, 2, 3 }));
        System.out.println(largestRectangleInHistogram.largestRectangleAreaApproachTwo(new int[] { 2, 1, 5, 6, 2, 3 }));
    }
}
