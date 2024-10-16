package com.company.microsoft.leetcode.medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int totalFuel = 0, stopCount = 0, j = i;
            while (stopCount < n) {
                totalFuel += gas[(j % n)] - cost[(j % n)];
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

    public int canCompleteCircuitApproachTwo(int[] gas, int[] cost) {
        /*
         * There are 2 passes over an array maximum.
         * We start at the beginning and the empty window. Try to grow it while there is
         * a gas. If gas is out, we move starting point forward, also adjusting the tank
         * accordingly. We finish when: a) window size is equal to gas.size() and this
         * is a solution or b) starting point goes out of gas.size() and there is no
         * solution exist.
         */
        int n = gas.length, windowStart = 0, windowEnd = 0, tank = 0;
        while (windowStart < n) {
            int curTank = tank + gas[windowEnd % n] - cost[windowEnd % n];
            if (curTank >= 0) {
                tank = curTank;
                if (windowEnd - windowStart == n) {
                    return windowStart;
                }
                windowEnd++;
            } else {
                windowEnd++;
                windowStart = windowEnd;
                tank = 0;
            }
        }

        return -1;
    }
}
