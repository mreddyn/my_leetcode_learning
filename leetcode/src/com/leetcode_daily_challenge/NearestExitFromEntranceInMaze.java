package com.leetcode_daily_challenge;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    private static int nearestExit(char[][] maze, int[] entrance) {
        int m, n, minSteps;
        m = maze.length;
        n = maze[0].length;
        minSteps = Integer.MAX_VALUE;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == '+') {
                    grid[i][j] = -1;
                } else {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        grid[entrance[0]][entrance[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { entrance[0], entrance[1] });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            if (row > 0 && grid[row - 1][col] == Integer.MAX_VALUE) {
                grid[row - 1][col] = grid[row][col] + 1;
                q.offer(new int[] { row - 1, col });
            }
            if (col > 0 && grid[row][col - 1] == Integer.MAX_VALUE) {
                grid[row][col - 1] = grid[row][col] + 1;
                q.offer(new int[] { row, col - 1 });
            }
            if (row < m - 1 && grid[row + 1][col] == Integer.MAX_VALUE) {
                grid[row + 1][col] = grid[row][col] + 1;
                q.offer(new int[] { row + 1, col });
            }
            if (col < n - 1 && grid[row][col + 1] == Integer.MAX_VALUE) {
                grid[row][col + 1] = grid[row][col] + 1;
                q.offer(new int[] { row, col + 1 });
            }
        }
        for (int i = 0; i < m; i++) {
            if (i == 0 || i == m - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.println(i + " " + j);
                    if (grid[i][j] != -1 && (i != entrance[0] && j != entrance[1])) {
                        // System.out.println(" i inside if : " + i + " " + j);
                        minSteps = Math.min(minSteps, grid[i][j]);
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (j == 0 || j == n - 1) {
                for (int i = 0; i < m; i++) {
                    System.out.println(i + " " + j);
                    if (grid[i][j] != -1 && (i != entrance[0] && j != entrance[1])) {
                        // System.out.println("j inside if : " + i + " " + j);
                        minSteps = Math.min(minSteps, grid[i][j]);
                    }
                }
            }
        }
        System.out.println();
        return (minSteps == Integer.MAX_VALUE) ? -1 : minSteps;
    }

    public static void main(String[] args) {
        char[][] maze = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };
        int[] entrance = { 1, 2 };
        System.out.println(nearestExit(maze, entrance));
    }
}
