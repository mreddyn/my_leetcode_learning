package com.leetcode.easy;

public class MaximumNumberOfBallsInABox {
    public int countBalls(int lowLimit, int highLimit) {
        /*
         * Since the biggest number possible is 99999 which the digitSum = 45.
         * So 45 is the maximum number of boxes for the given range.
         */
        int boxWithMostBalls = 0;
        var countMap = new int[46];
        for (int limit = lowLimit; limit <= highLimit; limit++) {
            int digitSum = getDigitSum(limit);
            countMap[digitSum]++;
        }

        for (int i = 1; i < 46; i++) {
            boxWithMostBalls = Math.max(boxWithMostBalls, countMap[i]);
        }

        return boxWithMostBalls;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
