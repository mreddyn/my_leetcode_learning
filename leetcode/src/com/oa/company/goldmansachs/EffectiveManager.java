package com.oa.company.goldmansachs;

import java.util.Arrays;

public class EffectiveManager {
    int maxMeetings(int[] effectiveness) {
        if (effectiveness == null || effectiveness.length == 0) {
            return 0;
        }

        // 1. Sort ascending
        Arrays.sort(effectiveness);

        long sum = 0; // use long if values can be large
        int count = 0;

        // start from the end of the array
        for (int i = effectiveness.length - 1; i >= 0; i--) {
            sum += effectiveness[i];
            if (sum > 0) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        var instance = new EffectiveManager();
        int[] effectiveness = { 1, -20, 3, -2 };
        System.out.println(instance.maxMeetings(effectiveness)); // Expected output: 3
        System.out.println(instance.maxMeetings(new int[] { 1, 2, 3, 4, 5 })); // Expected output: 5
        System.out.println(instance.maxMeetings(new int[] { -1, -2, -3, -4, -5 })); // Expected output: 0
    }
}
