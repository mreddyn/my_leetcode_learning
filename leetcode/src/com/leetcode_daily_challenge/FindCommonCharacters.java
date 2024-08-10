package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    private List<String> commonChars(String[] words) {
        List<String> commonCharsAmongWords = new ArrayList<>();

        int[] commonCharCount = new int[26];
        Arrays.fill(commonCharCount, Integer.MAX_VALUE);
        for (String word : words) {
            int wordLength = word.length();
            int[] currentWordCharCount = new int[26];
            // count the frequency of chars of current word
            for (int i = 0; i < wordLength; i++) {
                currentWordCharCount[word.charAt(i) - 'a']++;
            }

            // calculate the intersection of char count
            for (int i = 0; i < 26; i++) {
                commonCharCount[i] = Math.min(currentWordCharCount[i], commonCharCount[i]);
            }

        }

        // insert the chars into list
        for (int i = 0; i < 26; i++) {
            int freq = commonCharCount[i];
            while (freq-- > 0) {
                char c = (char) (i + 'a');
                commonCharsAmongWords.add(c + "");
            }
        }

        return commonCharsAmongWords;
    }

    public static void main(String[] args) {
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        System.out.println(findCommonCharacters.commonChars(new String[] { "bella", "label", "roller" }));
        System.out.println(findCommonCharacters.commonChars(new String[] { "cool", "lock", "cook" }));
    }
}
