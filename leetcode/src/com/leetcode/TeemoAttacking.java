package com.leetcode;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalPoisonedDuration = 0;
        for (int index = 0; index < timeSeries.length - 1; index++) {
            totalPoisonedDuration = totalPoisonedDuration
                    + Math.min(timeSeries[index + 1] - timeSeries[index], duration);
        }

        return totalPoisonedDuration + duration;
    }

    public static void main(String[] args) {
        System.out.println(new TeemoAttacking().findPoisonedDuration(new int[] { 1, 2, 4, 5, 7, 9 }, 2));
    }
}
