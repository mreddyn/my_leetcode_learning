package com.leetcode_daily_challenge;

public class DetermineIfACellIsReachableInGivenTime {
    private boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xxDistance = Math.abs(fx - sx);
        int yyDistance = Math.abs(fy - sy);
        if (xxDistance == 0 && yyDistance == 0 && t == 1) {
            return false;
        }
        int totalDistance = 0;
        if (xxDistance > yyDistance) {
            if (fx > sx) {
                totalDistance = yyDistance + (fx - (sx + yyDistance));
            } else {
                totalDistance = yyDistance + (sx - (fx + yyDistance));
            }
        } else {
            if (fy > sy) {
                totalDistance = xxDistance + (fy - (sy + xxDistance));
            } else {
                totalDistance = xxDistance + (sy - (fy + xxDistance));
            }
        }
        return totalDistance <= t;
    }

    public static void main(String[] args) {
        DetermineIfACellIsReachableInGivenTime dicirigt = new DetermineIfACellIsReachableInGivenTime();
        System.out.println(dicirigt.isReachableAtTime(3, 1, 7, 3, 3));
    }
}
