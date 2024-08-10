package com.leetcode;

public class NumberOfMatchingSubSequences {
    private int numMatchingSubSeq(String s, String[] words) {
        int matchingSequencesCount = 0, sLength = s.length();
        for (String word : words) {
            int sIndex, wordIndex, wordLength = word.length();
            for (sIndex = 0, wordIndex = 0; sIndex < sLength && wordIndex < wordLength; sIndex++) {
                wordIndex += (s.charAt(sIndex) == word.charAt(wordIndex)) ? 1 : 0;
            }
            if (wordIndex >= wordLength) {
                matchingSequencesCount++;
            }
        }

        return matchingSequencesCount;
    }

    public static void main(String[] args) {
        NumberOfMatchingSubSequences nSubSequences = new NumberOfMatchingSubSequences();
        System.out.println(nSubSequences.numMatchingSubSeq("dsahjpjauf", new String[] { "ahjpjau", "ja", "ahbwzgqnuk",
                "tnmlanowax" }));
    }
}
