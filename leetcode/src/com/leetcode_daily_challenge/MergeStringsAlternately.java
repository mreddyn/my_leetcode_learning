package com.leetcode_daily_challenge;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        int firstPointer;
        int secondPointer;
        firstPointer = secondPointer = 0;
        StringBuilder mergedString = new StringBuilder(word1Length + word2Length);
        while(firstPointer < word1Length && secondPointer < word2Length){
            mergedString.append(word1.charAt(firstPointer));
            mergedString.append(word2.charAt(secondPointer));
            firstPointer++;
            secondPointer++;
        }
        while(firstPointer < word1Length){
            mergedString.append(word1.charAt(firstPointer));
            firstPointer++;
        }
        while(secondPointer < word2Length){
            mergedString.append(word2.charAt(secondPointer));
            secondPointer++;
        }
        return mergedString.toString();
    }
}
