package com.leetcode.easy;

import java.util.HashMap;

public class CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        int commonWordsCount = 0;
        HashMap<String, Integer> wordsOneFreqMap = new HashMap<>();
        HashMap<String, Integer> wordsTwoFreqMap = new HashMap<>();
        for (String word : words1) {
            wordsOneFreqMap.put(word, wordsOneFreqMap.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            wordsTwoFreqMap.put(word, wordsTwoFreqMap.getOrDefault(word, 0) + 1);
        }

        for (String key : wordsOneFreqMap.keySet()) {
            int wordOneFreq = wordsOneFreqMap.get(key);
            if (wordOneFreq == 1 && wordsTwoFreqMap.containsKey(key) && wordsTwoFreqMap.get(key) == 1) {
                commonWordsCount++;
            }
        }

        return commonWordsCount;
    }

    public int countWordsApproachTwo(String[] words1, String[] words2) {
        int commonWordsCount = 0;
        HashMap<String, Integer> wordFreqMap = new HashMap<>();
        for (String word : words1) {
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            int freq = wordFreqMap.getOrDefault(word, 0);
            if (wordFreqMap.containsKey(word) && freq < 2) {
                wordFreqMap.put(word, freq - 1);
            }
        }

        for (String key : wordFreqMap.keySet()) {
            int freq = wordFreqMap.get(key);
            if (freq == 0) {
                commonWordsCount++;
            }
        }

        return commonWordsCount;
    }
}
