package com.company.amazon.leetcode.medium;

public class SeparateBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        int n = s.length(), whiteBallPosition = 0;
        long minSteps = 0;
        for (int i = 0; i < n; i++) {
            // if we see a black ball, we skip it
            // if we see a white ball, we calculate how many swaps it requires to move
            // it to the leftmost position i.e i-whiteBallPosition
            if (s.charAt(i) == '0') {
                minSteps += i - whiteBallPosition;
                whiteBallPosition++;

            }
        }
        return minSteps;
    }

    public long minimumStepsApproachTwo(String s) {
        /*
         * When we find a white ball in the array, we need to move it to the front by
         * swapping it past the black balls. Here's what that looks like:
         * 
         * To push a white ball to the front, we need to swap it with each black ball in
         * front of it. Each swap moves the white ball forward by one position. The
         * number of swaps for each white ball is equal to the number of black balls
         * before it.
         */

        long minimumSteps = 0, blackBallCount = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                minimumSteps += blackBallCount;
            } else {
                blackBallCount++;
            }
        }
        return minimumSteps;
    }
}
