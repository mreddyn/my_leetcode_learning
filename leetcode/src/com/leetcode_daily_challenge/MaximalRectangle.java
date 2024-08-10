package com.leetcode_daily_challenge;

import java.util.Stack;

public class MaximalRectangle {
    private int maximalRectangle(char[][] matrix) {
        int maxRectangleArea = 0, rows = matrix.length, cols = matrix[0].length;
        int[] heights = new int[cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '0') {
                    heights[col] = 0;
                } else {
                    heights[col] = heights[col] + 1;
                }
            }
            maxRectangleArea = Math.max(maxRectangleArea, maxRectangleInHistogram(heights));
        }

        return maxRectangleArea;
    }

    private int maxRectangleInHistogram(int[] heights) {
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
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        char[][] matrix = { { '1', '0', '1', '1', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalRectangle.maximalRectangle(matrix));
    }
}
