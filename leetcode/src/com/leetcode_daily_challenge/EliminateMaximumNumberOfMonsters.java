package com.leetcode_daily_challenge;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {
    private int eliminateMaximum(int[] dist, int[] speed) {
        int monstersEliminated = 0;
        double[] arrivalTime = new double[dist.length];
        for (int index = 0; index < dist.length; index++) {
            arrivalTime[index] = (double) dist[index] / speed[index];
        }
        Arrays.sort(arrivalTime);
        for (int index = 0; index < dist.length; index++) {
            if (arrivalTime[index] > index) {
                monstersEliminated++;
            } else {
                break;
            }
        }
        return monstersEliminated;
    }

    public static void main(String[] args) {
        EliminateMaximumNumberOfMonsters emnm = new EliminateMaximumNumberOfMonsters();
        int[] dist = { 1, 3, 4 };
        int[] speed = { 1, 1, 1 };
        System.out.println(emnm.eliminateMaximum(dist, speed));
    }
}
