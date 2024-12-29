package com.oa.company.xAi;

import java.util.*;

public class TetrisBlocks {
    public static int[][] solution(int n, int m, String[] figures) {
        int[][] grid = new int[n][m];
        Map<Character, int[][]> shapes = new HashMap<>();

        // Define the shapes
        shapes.put('A', new int[][] { { 1 } });
        shapes.put('B', new int[][] { { 1, 1, 1 } });
        shapes.put('C', new int[][] { { 1, 1 }, { 1, 1 } });
        shapes.put('D', new int[][] { { 1, 0 }, { 1, 1 }, { 1, 0 } });
        shapes.put('E', new int[][] { { 0, 1, 0 }, { 1, 1, 1 } });

        int figureIndex = 1; // Start with index 1 for each figure

        for (String figure : figures) {
            int[][] shape = shapes.get(figure.charAt(0));
            boolean placed = false;

            // Try to place the shape
            for (int i = 0; i <= n - shape.length; i++) {
                for (int j = 0; j <= m - shape[0].length; j++) {
                    if (canPlace(grid, shape, i, j)) {
                        placeShape(grid, shape, i, j, figureIndex);
                        figureIndex++;
                        placed = true;
                        break;
                    }
                }
                if (placed)
                    break;
            }
        }
        return grid;
    }

    private static boolean canPlace(int[][] grid, int[][] shape, int startRow, int startCol) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] == 1 && grid[startRow + i][startCol + j] != 0) {
                    return false; // Overlapping detected
                }
            }
        }
        return true; // Valid position
    }

    private static void placeShape(int[][] grid, int[][] shape, int startRow, int startCol, int index) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] == 1) {
                    grid[startRow + i][startCol + j] = index;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4, m = 4;
        String[] figures = { "D", "B", "A", "C" };

        int[][] result = solution(n, m, figures);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
