package com.leetcode;

public class MaximumEnemyFortsThatCanBeCaptured {
    private int captureForts(int[] forts) {
        int maxFortsCaptured = 0, n = forts.length;
        /*
         * Need to find the distance between friendly fort and
         * empty fort i.e, 1 and -1 or -1 and 1
         * and return the maximum distance
         * Also if there is no friendly fort then return 0, since we do not have an army
         */
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (forts[j] == -forts[i]) {
                    maxFortsCaptured = Math.max(maxFortsCaptured, i - j - 1);
                }
                j = i;
            }

        }
        return maxFortsCaptured;
    }

    public static void main(String[] args) {
        MaximumEnemyFortsThatCanBeCaptured maximumEnemyFortsThatCanBeCaptured = new MaximumEnemyFortsThatCanBeCaptured();
        System.out.println(maximumEnemyFortsThatCanBeCaptured.captureForts(new int[] { 1, 0, 0, -1, 0, 0, 0, 0, 1 }));
        System.out.println(maximumEnemyFortsThatCanBeCaptured.captureForts(new int[] { 0, 0, 1, -1 }));
    }
}
