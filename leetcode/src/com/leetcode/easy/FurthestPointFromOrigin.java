package com.leetcode.easy;

public class FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        /*
         * Since we can move left when we encounter 'L' or '_', and right when we
         * encounter
         * 'R' or '_'. so its better to move in that direction whichever 'L' count or
         * 'R' count is higher.
         * So maximum distance we can travel is max(lCount, rCount)+(dash count) -
         * min(lCount, rCount)
         */
        int maxDistanceFromOrigin = 0, n = moves.length();
        int lCount = 0, rCount = 0;
        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'L') {
                lCount++;
            } else if (moves.charAt(i) == 'R') {
                rCount++;
            }
        }

        maxDistanceFromOrigin = Math.max(lCount, rCount) + (n - (lCount + rCount)) - Math.min(lCount, rCount);

        return maxDistanceFromOrigin;
    }
}
