package com.company.microsoft.leetcode.medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int totalFuel = 0, stopCount = 0, j = i;
            while (stopCount < n) {
                totalFuel += gas[j % n] - cost[j % n];
                if (totalFuel < 0) {
                    // not possible to reach next gas station
                    break;
                }
                stopCount++;
                j++;
            }
            if (stopCount == n && totalFuel >= 0) {
                return i;
            }
        }

        return -1;
    }
}
