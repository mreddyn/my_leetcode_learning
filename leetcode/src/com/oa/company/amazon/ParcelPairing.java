package com.oa.company.amazon;

import java.util.HashMap;

public class ParcelPairing {
    private final int MOD = 1000000007;

    public int countBalancedPairs(int[] weights, int wt) {
        int count = 0;
        HashMap<Integer, Integer> weightFreq = new HashMap<>();
        // count the frequency of each weight
        for (int weight : weights) {
            weightFreq.put(weight, weightFreq.getOrDefault(weight, 0) + 1);
        }

        for(int weight : weights) {
            int currentCount = weightFreq.getOrDefault(weight, 0);
            if(currentCount == 0) {
                continue;
            }

            // check for weight+wt
            int pairWeight = weight+wt;
            int pairCount = weightFreq.getOrDefault(pairWeight, 0);

            int pairs = Math.min(pairCount, currentCount);

            // update the HashMap (decrease the frequency)
            if(pairs > 0) {
                count = (count + pairs) % MOD;
                weightFreq.put(weight, currentCount - pairs);
                weightFreq.put(weight, pairCount - pairs);
            }

            // check for weight-wt
            
        }

        return count;
    }
}
