package com.oa.company.amazon;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumMaximaCount {

    public static int findMaximumMaximumCount(String categories) {
        int maximaCount = 0, n = categories.length();
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        HashMap<Character, Integer> maximaCountMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = categories.charAt(i);
            // update the frequency of the current character
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);

            // Iterate through the HashMap find the max frequency
            int maxFrequency = 0;
            for (char ch : charFreqMap.keySet()) {
                int freq = charFreqMap.get(ch);
                maxFrequency = Math.max(freq, maxFrequency);
            }

            // Now for all the chars in the hashmap, check how many times their frequency
            // matches maxFrequency
            for (char ch : charFreqMap.keySet()) {
                int freq = charFreqMap.get(ch);
                if (freq == maxFrequency) {
                    maximaCountMap.put(ch, maximaCountMap.getOrDefault(ch, 0) + 1);
                }
            }
        }

        // Now find out which char has highest maximaCount
        for (char ch : maximaCountMap.keySet()) {
            int freq = maximaCountMap.get(ch);
            maximaCount = Math.max(maximaCount, freq);
        }

        return maximaCount;
    }

    public static int findMaximumMaximumCountApproachTwo(String categories) {
        // write your code here
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int maxCount = 0;
        HashSet<Character> maxChars = new HashSet<>();
        HashMap<Character, Integer> timesOfWin = new HashMap<>();
        for (int i = 0; i < categories.length(); i++) {
            char c = categories.charAt(i);
            int newFreq = 0;
            if (freqMap.containsKey(c)) {
                newFreq = freqMap.get(c) + 1;
            } else {
                newFreq = 1;
            }
            freqMap.put(c, newFreq);
            if (newFreq > maxCount) {
                timesOfWin.put(c, timesOfWin.getOrDefault(c, 0) + 1);
                maxCount = newFreq;
                maxChars.clear();
                maxChars.add(c);
            } else if (newFreq == maxCount) {
                maxChars.add(c);
                for (Character winner : maxChars) {
                    timesOfWin.put(winner, timesOfWin.getOrDefault(winner, 0) + 1);
                }
            } else {
                for (Character winner : maxChars) {
                    timesOfWin.put(winner, timesOfWin.getOrDefault(winner, 0) + 1);
                }
            }
        }

        int maxWins = 0;
        for (Integer max : timesOfWin.values()) {
            if (max > maxWins) {
                maxWins = max;
            }
        }

        return maxWins;
    }

    public static void main(String[] args) {
        String categories1 = "bccaaacb";
        System.out.println(findMaximumMaximumCount(categories1)); // Output: 6
        System.out.println(findMaximumMaximumCountApproachTwo(categories1)); // Output: 6

        String categories2 = "zzzz";
        System.out.println(findMaximumMaximumCount(categories2)); // Output: 4
        System.out.println(findMaximumMaximumCountApproachTwo(categories2)); // Output: 4
    }
}
