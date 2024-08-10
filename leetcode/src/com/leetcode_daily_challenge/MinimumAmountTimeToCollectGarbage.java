package com.leetcode_daily_challenge;

public class MinimumAmountTimeToCollectGarbage {
    private int garbageCollection(String[] garbage, int[] travel) {
        int totalHouses = garbage.length;
        int metalGarbageTime = 0;
        int glassGarbageTime = 0;
        int paperGarbageTime = 0;
        int metalGarbageLastHouse = 0;
        int glassGarbageLastHouse = 0;
        int paperGarbageLastHouse = 0;
        for (int i = 0; i < totalHouses; i++) {
            char[] garbageType = garbage[i].toCharArray();
            for (int j = 0; j < garbageType.length; j++) {
                if (garbageType[j] == 'M') {
                    metalGarbageLastHouse = i;
                } else if (garbageType[j] == 'G') {
                    glassGarbageLastHouse = i;
                } else {
                    paperGarbageLastHouse = i;
                }
            }
        }
        for (int i = 0; i < totalHouses;) {
            char[] garbageType = garbage[i].toCharArray();
            for (int j = 0; j < garbageType.length; j++) {
                if (garbageType[j] == 'M') {
                    metalGarbageTime += 1;
                } else if (garbageType[j] == 'G') {
                    glassGarbageTime += 1;
                } else {
                    paperGarbageTime += 1;
                }
            }
            i++;
            System.out.println(i);
            if (i <= metalGarbageLastHouse) {
                metalGarbageTime += travel[i - 1];
            }
            if (i <= glassGarbageLastHouse) {
                glassGarbageTime += travel[i - 1];
            }
            if (i <= paperGarbageLastHouse) {
                paperGarbageTime += travel[i - 1];
            }
        }
        return metalGarbageTime + glassGarbageTime + paperGarbageTime;
    }

    public static void main(String[] args) {
        MinimumAmountTimeToCollectGarbage minimumAmountTimeToCollectGarbage = new MinimumAmountTimeToCollectGarbage();
        String[] garbage = { "MMM", "PGM", "GP" };
        int[] travel = { 3, 10 };
        System.out.println(minimumAmountTimeToCollectGarbage.garbageCollection(garbage, travel));
    }
}
