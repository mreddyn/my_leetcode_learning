package com.leetcode.hard;

import java.util.ArrayDeque;
import java.util.HashSet;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        /*
         * There are siz states where zero can be any index from 0 to 5
         * 012345, 102345, 120345, 123045, 123405, 123450
         * 
         * when 0 is at 0 index then it can only move to indices 1, 3. This can be
         * explained by imagine the board (2*3)
         * 0 1 2
         * 3 4 5 => {1, 3}
         * 
         * 1 0 2
         * 3 4 5 => {0, 2, 4} (0 can move to 1's place or 2's place or 4's place)
         * 
         * similarly we can determine other states too.
         * 120345 => {1, 5}
         * 123045 => {0, 4}
         * 123405 => {1, 3, 5}
         * 123450 => {2,4}
         * 
         * So we will do BFS search visit all the states where 0 can move.
         * if we get a final state where 123450 then return the moves.
         */
        int moves = 0;
        var target = "123450";
        var start = new StringBuilder(6);
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                start.append(board[row][col]);
            }
        }

        var queue = new ArrayDeque<String>();
        var visited = new HashSet<String>();
        int[][] directions = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        queue.offer(start.toString());
        visited.add(start.toString());

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                var cur = queue.poll();
                if (cur.equals(target)) {
                    return moves;
                }

                // get 0 position
                int index = cur.indexOf('0');

                // move 0 to possible directions
                for (var direction : directions[index]) {
                    String next = move(cur, index, direction);
                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private String move(String str, int i, int j) {
        var sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
