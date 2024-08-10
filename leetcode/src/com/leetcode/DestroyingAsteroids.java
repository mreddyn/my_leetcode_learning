package com.leetcode;

import java.util.Arrays;

public class DestroyingAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        long planetMass = mass;
        Arrays.sort(asteroids);
        for (int i = 0; i < n; i++) {
            if (planetMass < asteroids[i]) {
                return false;
            } else if (planetMass > 100000) {
                return true;
            }
            planetMass += asteroids[i];
        }

        return true;
    }
}
