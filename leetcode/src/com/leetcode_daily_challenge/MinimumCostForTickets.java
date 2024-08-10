package com.leetcode_daily_challenge;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay;
        int oneDayPass;
        int sevenDayPass;
        int thirtyDayPass;
        oneDayPass = costs[0];
        sevenDayPass = costs[1];
        thirtyDayPass = costs[2];
        lastDay = days[days.length - 1];
        int[] totalDays = new int[lastDay + 1];
        Set<Integer> travelingDays = new HashSet<>();
        for (int day : days) {
            travelingDays.add(day);
        }
        System.out.println(travelingDays);
        for (int day = 1; day < totalDays.length; day++) {
            if (travelingDays.contains(day)) {
                int canUseSevenDayPass = sevenDayPass;
                if (day - 7 >= 0) {
                    canUseSevenDayPass += totalDays[day - 7];
                }

                int canUseThirtyDayPass = thirtyDayPass;
                if (day - 30 >= 0) {
                    canUseThirtyDayPass += totalDays[day - 30];
                }

                totalDays[day] = Math.min(oneDayPass + totalDays[day
                        - 1], Math.min(canUseSevenDayPass, canUseThirtyDayPass));
            } else {
                totalDays[day] = totalDays[day - 1];
            }
        }
        for (int day : totalDays) {
            System.out.print(day + " ");
        }
        System.out.println();
        return totalDays[totalDays.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(
                new MinimumCostForTickets().mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 }));
    }
}
