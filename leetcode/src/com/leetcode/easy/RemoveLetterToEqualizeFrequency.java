package com.leetcode.easy;

import java.util.HashMap;

public class RemoveLetterToEqualizeFrequency {
    public boolean equalFrequency(String word) {
        /*
         * We count characters, and then count the frequency of each count.
         * 
         * For example, for the string "abcc", the character count is {'c': 2, 'a': 1,
         * 'b': 1}, and frequency of each count is {1: 2, 2: 1} (one letters appear two
         * times, and two letters appear one time each).
         * 
         * We can equalize the string if the frequency counter contains one or two
         * elements, and there are four cases:
         * 
         * "abcde" {1: 5}
         * "aaaaa" {5: 1}
         * "abbcc" {1: 1, 2: 2}
         * "aaabbcc" {3: 1, 2: 2}
         */
        int n = word.length();
        int[] charFreqCount = new int[26];
        for (int i = 0; i < n; i++) {
            charFreqCount[word.charAt(i) - 'a']++;
        }

        HashMap<Integer, Integer> freqCounterMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (charFreqCount[i] == 0) {
                continue;
            }
            int freq = charFreqCount[i];
            freqCounterMap.put(freq, freqCounterMap.getOrDefault(freq, 0) + 1);
        }

        if (freqCounterMap.size() == 1) {
            return freqCounterMap.containsKey(1) || freqCounterMap.values().contains(1);

        } else if (freqCounterMap.size() == 2) {
            int[] keys = new int[2];
            int index = 0;
            for (int freq : freqCounterMap.keySet()) {
                keys[index++] = freq;
            }

            int minFreq = Math.min(keys[0], keys[1]);
            int maxFreq = Math.max(keys[0], keys[1]);
            return (minFreq + 1 == maxFreq && freqCounterMap.get(maxFreq) == 1) ||
                    (minFreq == 1 && freqCounterMap.get(minFreq) == 1);

        }

        return false;
    }
}
