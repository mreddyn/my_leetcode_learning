package com.oa.company.amazon;

import java.util.HashMap;

public class FindMinimumTrips {
    public int findMinTrips(int[] packageweight) {
        int tripsCount = 0, n = packageweight.length;
        HashMap<Integer, Integer> weightFreqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            weightFreqMap.put(packageweight[i], weightFreqMap.getOrDefault(packageweight[i], 0) + 1);
        }

        for (int weight : weightFreqMap.keySet()) {
            int freq = weightFreqMap.get(weight);
            if (freq >= 2) {
                tripsCount++;
            }
        }
        System.out.println(weightFreqMap);
        return tripsCount == 0 ? -1 : tripsCount;
    }

    public static void main(String[] args) {
        FindMinimumTrips fTrips = new FindMinimumTrips();
        System.out.println(fTrips.findMinTrips(new int[] { 1, 8, 5, 8, 5, 1, 1 }));
    }
}
