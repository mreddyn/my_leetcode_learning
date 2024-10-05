package com.company.facebook.medium;

import java.util.HashMap;

public class MaximumTotalDamageWithSpellCasting {
    public long maximumTotalDamage(int[] power) {
        long maxTotalDamage = 0;
        var powerFreqMap = new HashMap<Integer,Integer>();
        for(int pow : power) {
            powerFreqMap.put(pow, powerFreqMap.getOrDefault(pow, 0)+1);
        }

        

        return maxTotalDamage;
    }
}
