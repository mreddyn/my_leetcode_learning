package com.company.chewy;

import java.util.HashSet;
import java.util.Set;

public class CountVowelStringsInRanges {
    private int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        // add vowels to set for constant lookup
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        // declare a int array to store if a word ends and starts with vowel or not, 1
        // indicates YES, and 0 for NO
        int[] prefix = new int[n + 1];
        int prefixIndex = 1;
        for (String word : words) {
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length() - 1);
            if (vowelSet.contains(firstChar) && vowelSet.contains(lastChar)) {
                // if condition satisfies we increase by 1, else prefix stays same
                prefix[prefixIndex] = 1;
            }
            prefixIndex++;
        }

        // calculate prefix sum
        for (int i = 1; i < n + 1; i++) {
            prefix[i] += prefix[i - 1];
        }

        int[] result = new int[queries.length];
        int resultIndex = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            result[resultIndex++] = prefix[r + 1] - prefix[l];
        }
        return result;
    }

    public static void main(String[] args) {
        CountVowelStringsInRanges cInRanges = new CountVowelStringsInRanges();
        cInRanges.vowelStrings(new String[] { "aba" }, new int[][] { { 0, 2 } });
    }
}
