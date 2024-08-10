package com.company.amazon.leetcode.easy;

import java.util.HashSet;

public class PathCrossing {
    public boolean isPathCrossing(String path) {
        int n = path.length(), x = 0, y = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add(x + "a" + y);
        for (int i = 0; i < n; i++) {
            System.out.println(visited);
            char ch = path.charAt(i);
            if (ch == 'N') {
                y++;
            } else if (ch == 'S') {
                y--;
            } else if (ch == 'E') {
                x++;
            } else {
                x--;
            }
            String point = x + "a" + y;
            if (visited.contains(point)) {
                return true;
            }
            visited.add(point);
        }

        return false;
    }

    public static void main(String[] args) {
        PathCrossing pathCrossing = new PathCrossing();
        System.out.println(pathCrossing.isPathCrossing("ENNNNNNNNNNNEEEEEEEEEESSSSSSSSSS"));
    }
}
