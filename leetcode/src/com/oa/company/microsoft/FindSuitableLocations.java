package com.oa.company.microsoft;

import java.util.ArrayDeque;

public class FindSuitableLocations {
    private final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int findSuitableLocations(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int suitableLocationCount = 0;
        // we will do a BFS from each empty plot to all houses (grid[i][j] == 1)
        // if we can reach all houses within k steps, then this empty plot is suitable
        // we will do this for all empty plots, we can skip an empty plot if any house
        // distance is > k

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    // this is an empty plot
                    var visited = new boolean[rows][cols];
                    var dis = new int[rows][cols];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            dis[i][j] = Integer.MAX_VALUE;
                        }
                    }
                    dis[row][col] = 0;
                    var queue = new ArrayDeque<int[]>();
                    queue.offer(new int[] { row, col });
                    visited[row][col] = true;

                    while (!queue.isEmpty()) {
                        var cur = queue.poll();

                        for (var direction : directions) {
                            int newRow = cur[0] + direction[0];
                            int newCol = cur[1] + direction[1];

                            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols
                                    || dis[newRow][newCol] != Integer.MAX_VALUE) {
                                continue;
                            }

                            dis[newRow][newCol] = dis[cur[0]][cur[1]] + 1;
                            if (!visited[newRow][newCol]) {
                                queue.offer(new int[] { newRow, newCol });
                                visited[newRow][newCol] = true;
                            }
                        }
                    }

                    boolean isSuitable = true;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            if (grid[i][j] == 1 && dis[i][j] > k) {
                                isSuitable = false;
                                break;
                            }
                        }
                    }

                    if (isSuitable) {
                        suitableLocationCount++;
                    }
                }
            }
        }

        return suitableLocationCount;
    }

    public static void main(String[] args) {
        FindSuitableLocations obj = new FindSuitableLocations();
        int[][] grid = {
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 },
                { 1, 0, 0, 1 }
        };
        int k = 2;
        System.out.println(obj.findSuitableLocations(grid, k)); // should be 1
    }
}
