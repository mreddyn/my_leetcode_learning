package com.company.doordash;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class GetClosestDashMart {
    private final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<Integer> getDistance(char[][] board, int[][] locations) {
        int m = board.length;
        int n = board[0].length;

        var grid = new int[m][n];
        var queue = new ArrayDeque<int[]>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'D') {
                    queue.offer(new int[] { i, j });
                } else if (board[i][j] == 'X') {
                    grid[i][j] = -1;
                } else {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // start BFS from all DashMarts
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (var direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (isOutOfBounds(newX, newY, m, n)) {
                    continue;
                }

                if (grid[newX][newY] == -1) {
                    // if it is a wall or blocked then continue
                    continue;
                }

                if (grid[newX][newY] != Integer.MAX_VALUE) {
                    // if it is not Integer.MAX_VALUE then it indicates that a dashmart is already
                    // near this location
                    continue;
                }

                grid[newX][newY] = grid[x][y] + 1;
                queue.offer(new int[] { newX, newY });
            }
        }

        var res = new ArrayList<Integer>(locations.length);
        for (var location : locations) {
            int x = location[0];
            int y = location[1];

            if (isOutOfBounds(x, y, m, n)) {
                res.add(-1);
                continue;
            }

            res.add(grid[x][y]);
        }

        return res;
    }

    private boolean isOutOfBounds(int x, int y, int m, int n) {
        return (x < 0 || y < 0 || x >= m || y >= n);
    }

    public static void main(String[] args) {
        GetClosestDashMart getClosestDashMart = new GetClosestDashMart();
        char[][] locationBoard = {
                { 'X', ' ', ' ', 'D', ' ', ' ', 'X', ' ', 'X' },
                { 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X' },
                { ' ', ' ', ' ', 'D', 'X', 'X', ' ', 'X', ' ' },
                { ' ', ' ', ' ', 'D', ' ', 'X', ' ', ' ', ' ' },
                { ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X' },
                { ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X' } };

        int[][] locations = {
                { 200, 200 },
                { 1, 4 },
                { 0, 3 },
                { 5, 8 },
                { 1, 8 },
                { 5, 5 }
        };

        System.out.println(getClosestDashMart.getDistance(locationBoard, locations));
    }
}
