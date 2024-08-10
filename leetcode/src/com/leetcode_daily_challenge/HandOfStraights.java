package com.leetcode_daily_challenge;

import java.util.TreeMap;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // maintain a frequency map of hand values in a TreeMap, TreeMap ensures the keys are sorted in ascending order
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // loop through the map, get the keys one by one.
        while (map.size() > 0) {
            int minElement = map.firstKey();
            int minElementFreq = map.get(minElement);
            // Check if we can create minOccurrences sequences of k consecutive numbers with
            // the min as the first number.
            for (int i = 0; i < groupSize; ++i) {
                if (map.containsKey(minElement + i) && minElementFreq <= map.get(minElement + i)) {
                    map.put(minElement + i, map.get(minElement + i) - minElementFreq);
                    if (map.get(minElement + i) == 0) {
                        // remove minElement+1 since there are no more occurrences
                        map.remove(minElement + i);
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
