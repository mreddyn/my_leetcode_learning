package com.leetcode;

import java.util.ArrayDeque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        /*
         * negative asteroids without any positive asteroids (which are traveling right)
         * can be ignored, since they won't collide.
         * We only need to care about positive asteroids that come before negative
         * asteroids
         * Maintain a stack and arrayList
         * If we encounter a positive asteroid we will push it to stack, as it may
         * collide with future negative asteroid
         * If we encounter a negative asteroid and stack is empty then add it to final
         * list
         * If we encounter a negative asteroid and stack is not empty then we run a loop
         * to check if top asteroid from stack is greater than current negative asteroid
         * or not.
         * if it is greater then ignore negative asteroid and continue.
         * else if both are equal pop the positive asteroid and continue.
         * else destroy the positive asteroid and check again.
         */
        int n = asteroids.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            boolean isNegativeAsteroidDestroyed = false;
            int curAsteroid = asteroids[i];
            if (curAsteroid > 0) {
                stack.push(curAsteroid);
                continue;
            } else if (curAsteroid < 0 && stack.isEmpty()) {
                stack.push(curAsteroid);
                continue;
            }
            while (!stack.isEmpty() && curAsteroid < 0 && stack.peek() > 0) {
                if (-curAsteroid == stack.peek()) {
                    // if both are equal then destroy both
                    stack.pop();
                    isNegativeAsteroidDestroyed = true;
                    break;
                } else if (-curAsteroid < stack.peek()) {
                    // if the negative is less then positive asteroid then destroy it
                    isNegativeAsteroidDestroyed = true;
                    break;
                } else {
                    // if negative asteroid is larger then pop the positive asteroid
                    stack.pop();
                    isNegativeAsteroidDestroyed = false;
                    continue;
                }
            }
            if (!isNegativeAsteroidDestroyed) {
                // if negative asteroid survived all collisions then add it to stack
                stack.push(curAsteroid);
            }

        }

        int index, size = stack.size();
        int[] remainingAsteroids = new int[size];
        index = size - 1;
        while (size-- > 0) {
            remainingAsteroids[index--] = stack.pop();
        }

        return remainingAsteroids;
    }
}
