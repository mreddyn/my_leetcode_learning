package com.oa.company.amazon;

import java.util.HashMap;

public class RoombaRobotsBlocking {
    /*
     * https://leetcode.com/discuss/interview-question/5271091/amazon-oa
     * Amazon uses small, Roomba-
     * shaped robots, called "Drives". They deliver large stacks of products to
     * human workers by following set paths around the warehouse.
     * The warehouse can be represented in the form of a cartesian plane, where
     * robots are located at integral points of the form (x, y). When a product is
     * to be delivered to some point (i, j), the nearest robot is sought and chosen.
     * Thus if a robot is surrounded by other robots nearby, it will seldom® be
     * chosen for work. More formally, a robot is said to be idle if it has a robot
     * located above, below, left, and right of it. It is guaranteed that no two
     * robots are at the same location.
     * Given the locations of n robots, find the number of idle robots.
     * Example
     * The x and y coordinates are given as two arrays,
     * with the coordinates aligned by index: x = [1, 1, 1,
     * 2, 2, 2, 2, 3, 3, 3] and y = [1, 2, 3, 1, 2, 3, 5, 1, 2, 3].
     * • The robot at (2, 2) is idle because it has robots at (1, 2), (3, 2), (2,
     * 3), and (2, 1) directly to the left, right, up, and down respectively.
     * • The robot at (2, 3) is idle because it has robots at (1, 3), (3, 3), (2,
     * 5), and (2, 2) directly to the left, right, up, and down respectively.
     * There are 2 idle robots in this arrangement.
     */
    public int numberOfRobotsBlocked(int[] x, int[] y) {
        /*
         * calculate the minimum X value, maximum X value and minimum Y value, maximum Y
         * value.
         * After calculating check if a given robot on XY plane lies be
         */
        int n = x.length, idleRobots = 0;
        HashMap<Integer, Integer> maxX = new HashMap<>();
        HashMap<Integer, Integer> maxY = new HashMap<>();
        HashMap<Integer, Integer> minX = new HashMap<>();
        HashMap<Integer, Integer> minY = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (x[i] > maxX.getOrDefault(y[i], Integer.MIN_VALUE)) {
                maxX.put(y[i], x[i]);
            }
            if (x[i] < minX.getOrDefault(y[i], Integer.MAX_VALUE)) {
                minX.put(y[i], x[i]);
            }
            if (y[i] > maxY.getOrDefault(x[i], Integer.MIN_VALUE)) {
                maxY.put(x[i], y[i]);
            }
            if (y[i] < minY.getOrDefault(x[i], Integer.MAX_VALUE)) {
                minY.put(x[i], y[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (x[i] != maxX.get(y[i])
                    && x[i] != minX.get(y[i])
                    && y[i] != maxY.get(x[i])
                    && y[i] != minY.get(x[i])) {
                idleRobots++;
            }
        }

        return idleRobots;
    }
}
