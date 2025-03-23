package com.oa.company.goldmansachs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMoves {
    /**
     * Returns the minimum number of moves needed to go from (0,0) to (n-1,m-1)
     * in the given maze with jump parameter k, or -1 if it's not possible.
     *
     * maze: n x m grid (0 = free cell, 1 = obstacle)
     * k: max jump distance in one move
     */
    public static int getMinimumMoves(int[][] maze, int k) {
        int n = maze.length;
        int m = maze[0].length;

        // Edge case: if start or end is blocked, no path.
        if (maze[0][0] == 1 || maze[n - 1][m - 1] == 1) {
            return -1;
        }

        // Build prefix sums for rows and columns to quickly check obstacles
        int[][] rowPrefix = buildRowPrefix(maze);
        int[][] colPrefix = buildColPrefix(maze);

        // BFS initialization
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // Start from (0,0) with distance 0
        visited[0][0] = true;
        queue.offer(new int[] { 0, 0, 0 }); // row, col, distance

        // BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            // If we reached the target, return the distance
            if (r == n - 1 && c == m - 1) {
                return dist;
            }

            // Try jumps in all four directions
            // 1. Move down: (r + jump, c)
            for (int jump = 1; jump <= k; jump++) {
                int nr = r + jump;
                if (nr >= n)
                    break; // out of bounds if we go further
                if (hasObstacleInColumn(colPrefix, c, r + 1, nr))
                    break; // blocked
                if (!visited[nr][c]) {
                    visited[nr][c] = true;
                    queue.offer(new int[] { nr, c, dist + 1 });
                }
            }

            // 2. Move up: (r - jump, c)
            for (int jump = 1; jump <= k; jump++) {
                int nr = r - jump;
                if (nr < 0)
                    break; // out of bounds if we go further
                if (hasObstacleInColumn(colPrefix, c, nr, r - 1))
                    break; // blocked
                if (!visited[nr][c]) {
                    visited[nr][c] = true;
                    queue.offer(new int[] { nr, c, dist + 1 });
                }
            }

            // 3. Move right: (r, c + jump)
            for (int jump = 1; jump <= k; jump++) {
                int nc = c + jump;
                if (nc >= m)
                    break; // out of bounds if we go further
                if (hasObstacleInRow(rowPrefix, r, c + 1, nc))
                    break; // blocked
                if (!visited[r][nc]) {
                    visited[r][nc] = true;
                    queue.offer(new int[] { r, nc, dist + 1 });
                }
            }

            // 4. Move left: (r, c - jump)
            for (int jump = 1; jump <= k; jump++) {
                int nc = c - jump;
                if (nc < 0)
                    break; // out of bounds if we go further
                if (hasObstacleInRow(rowPrefix, r, nc, c - 1))
                    break; // blocked
                if (!visited[r][nc]) {
                    visited[r][nc] = true;
                    queue.offer(new int[] { r, nc, dist + 1 });
                }
            }
        }

        // If we exhausted the queue without reaching target, no path exists
        return -1;
    }

    // Build a prefix sum for each row: rowPrefix[r][c] = # of obstacles in row r
    // from col 0..c
    private static int[][] buildRowPrefix(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] rowPrefix = new int[n][m];

        for (int r = 0; r < n; r++) {
            int runningSum = 0;
            for (int c = 0; c < m; c++) {
                runningSum += maze[r][c];
                rowPrefix[r][c] = runningSum;
            }
        }
        return rowPrefix;
    }

    // Build a prefix sum for each column: colPrefix[c][r] = # of obstacles in
    // column c from row 0..r
    private static int[][] buildColPrefix(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] colPrefix = new int[m][n];

        for (int c = 0; c < m; c++) {
            int runningSum = 0;
            for (int r = 0; r < n; r++) {
                runningSum += maze[r][c];
                colPrefix[c][r] = runningSum;
            }
        }
        return colPrefix;
    }

    /**
     * Checks if there's an obstacle in row r between columns cStart..cEnd
     * (inclusive).
     * We'll use rowPrefix[r][x] to see how many obstacles up to column x.
     * If the difference of prefix sums > 0, there's at least one obstacle.
     * 
     * We assume cStart <= cEnd.
     */
    private static boolean hasObstacleInRow(int[][] rowPrefix, int r, int cStart, int cEnd) {
        if (cStart > cEnd)
            return false; // no segment
        int leftVal = cStart - 1 >= 0 ? rowPrefix[r][cStart - 1] : 0;
        int rightVal = rowPrefix[r][cEnd];
        int obstacles = rightVal - leftVal;
        return obstacles > 0; // if > 0, there's at least one obstacle
    }

    /**
     * Checks if there's an obstacle in column c between rows rStart..rEnd
     * (inclusive).
     * We'll use colPrefix[c][x] to see how many obstacles up to row x.
     * If the difference of prefix sums > 0, there's at least one obstacle.
     * 
     * We assume rStart <= rEnd.
     */
    private static boolean hasObstacleInColumn(int[][] colPrefix, int c, int rStart, int rEnd) {
        if (rStart > rEnd)
            return false; // no segment
        int topVal = rStart - 1 >= 0 ? colPrefix[c][rStart - 1] : 0;
        int bottomVal = colPrefix[c][rEnd];
        int obstacles = bottomVal - topVal;
        return obstacles > 0; // if > 0, there's at least one obstacle
    }

    // A main for demonstration with the sample test cases:
    public static void main(String[] args) {
        // Example 1
        int[][] maze1 = {
                { 0, 1 },
                { 1, 0 }
        };
        int k1 = 2;
        System.out.println(getMinimumMoves(maze1, k1)); // Expected 2

        // Example 2
        int[][] maze2 = {
                { 0, 0, 0 },
                { 1, 0, 0 },
                { 1, 0, 0 }
        };
        int k2 = 5;
        System.out.println(getMinimumMoves(maze2, k2)); // Expected 2

        // Example 3
        int[][] maze3 = {
                { 0, 1, 0 },
                { 1, 1, 0 },
                { 1, 0, 0 }
        };
        int k3 = 5;
        System.out.println(getMinimumMoves(maze3, k3)); // Expected -1
    }
}
