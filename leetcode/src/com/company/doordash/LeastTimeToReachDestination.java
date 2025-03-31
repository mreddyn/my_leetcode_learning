package com.company.doordash;

import java.util.PriorityQueue;

public class LeastTimeToReachDestination {
    private final int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxElevation = 0;

        var visited = new boolean[m][n];
        var queue = new PriorityQueue<Cell>((a, b) -> a.time - b.time);

        queue.offer(new Cell(0, 0, grid[0][0]));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            var cell = queue.poll();
            int x = cell.x;
            int y = cell.y;
            int time = cell.time;

            for (int[] dir : directions) {
                int newRow = x + dir[0];
                int newCol = y + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    maxElevation = Math.max(time, grid[newRow][newCol]);

                    if (newRow == m - 1 && newCol == n - 1) {
                        return maxElevation;
                    }
                    queue.offer(new Cell(newRow, newCol, maxElevation));
                }
            }
        }

        return 0;
    }

    class Cell {
        int x;
        int y;
        int time;

        Cell(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 1, 2, 3, 4 },
                { 24, 16, 22, 21, 5 },
                { 12, 13, 14, 15, 23 },
                { 11, 17, 18, 19, 20 },
                { 10, 9, 8, 7, 6 } };

        LeastTimeToReachDestination obj = new LeastTimeToReachDestination();
        int result = obj.swimInWater(grid);
        System.out.println("Least time to reach destination: " + result); // 16
    }
}
