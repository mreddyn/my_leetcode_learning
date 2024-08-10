package com.company.microsoft.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    private int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc });
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr[] = queue.poll();
                int x = curr[0];
                int y = curr[1];
                image[x][y] = color;
                if (x - 1 >= 0 && image[x - 1][y] == oldColor) {
                    queue.add(new int[] { x - 1, y });
                }
                if (x + 1 < image.length && image[x + 1][y] == oldColor) {
                    queue.add(new int[] { x + 1, y });
                }
                if (y - 1 >= 0 && image[x][y - 1] == oldColor) {
                    queue.add(new int[] { x, y - 1 });
                }
                if (y + 1 < image[0].length && image[x][y + 1] == oldColor) {
                    queue.add(new int[] { x, y + 1 });
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int[][] result = floodFill.floodFill(image, 1, 1, 2);
        for (int[] row : result) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
