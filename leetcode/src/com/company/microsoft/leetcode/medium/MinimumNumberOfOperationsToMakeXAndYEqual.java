package com.company.microsoft.leetcode.medium;

import java.util.ArrayDeque;
import java.util.HashSet;

public class MinimumNumberOfOperationsToMakeXAndYEqual {
    public int minimumOperationsToMakeEqual(int x, int y) {
        /*
         * when y > x we can return just y-x (since increment is only by 1)
         * if x > y, then we will do a BFS starting from x until it is equal to y.
         * we will maintain a set to overcome redundant operations.
         * at every level we will do +1, -1, /11, /5.
         * The number of levels represents the number of operations it takes
         * for x to reach y.
         */
        if (x < y) {
            return y - x;
        }

        int operations = 0;
        var seen = new HashSet<Integer>();
        var queue = new ArrayDeque<Integer>();
        queue.offer(x);
        seen.add(x);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curX = queue.poll();
                if (curX == y) {
                    return operations;
                }
                if (!seen.contains(curX + 1)) {
                    queue.offer(curX + 1);
                    seen.add(curX + 1);
                }

                if (!seen.contains(curX - 1)) {
                    queue.offer(curX - 1);
                    seen.add(curX - 1);
                }
                if (curX % 11 == 0 && !seen.contains(curX / 11)) {
                    queue.offer(curX / 11);
                    seen.add(curX / 11);
                }
                if (curX % 5 == 0 && !seen.contains(curX / 5)) {
                    queue.offer(curX / 5);
                    seen.add(curX / 5);
                }
            }
            operations++;
        }
        return operations;
    }
}
