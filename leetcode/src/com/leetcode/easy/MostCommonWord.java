package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {

        // split the paragraph into words
        String[] words = paragraph.toLowerCase().split("\\W+");

        // add banned words to set
        var bannedSet = new HashSet<String>(Arrays.asList(banned));

        // add non-banned words to wordMap
        var wordMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        String mostCommonWord = "";
        int mostCommonWordFreq = 0;
        for (String word : wordMap.keySet()) {
            int wordFreq = wordMap.get(word);
            if (mostCommonWordFreq < wordFreq) {
                mostCommonWordFreq = wordFreq;
                mostCommonWord = word;
            }
        }

        return mostCommonWord;
    }
}
