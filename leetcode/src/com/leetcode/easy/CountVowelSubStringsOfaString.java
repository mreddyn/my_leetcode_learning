package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CountVowelSubStringsOfaString {
    public int countVowelSubstrings(String word) {
        int subStringsCount = 0, n = word.length();
        if (n < 5) {
            return subStringsCount;
        }

        var vowelSet = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int end = 0; end < n - 4; end++) {
            var vowelsInWindow = new HashSet<Character>();
            for (int start = end; start < n; start++) {
                char c = word.charAt(start);
                if (vowelSet.contains(c)) {
                    vowelsInWindow.add(c);
                } else {
                    break;
                }

                if (vowelsInWindow.size() == 5) {
                    subStringsCount++;
                }
            }
        }

        return subStringsCount;
    }

    public int countVowelSubstringsApproachTwo(String word) {
        int subStringsCount = 0;
        int substringsWithAtMostFiveUniqueVowels = countSubStringsWithAtLeastKUniqueVowels(word, 5);
        int substringsWithAtMostFourUniqueVowels = countSubStringsWithAtLeastKUniqueVowels(word, 4);
        subStringsCount = substringsWithAtMostFiveUniqueVowels - substringsWithAtMostFourUniqueVowels;
        return subStringsCount;
    }

    private int countSubStringsWithAtLeastKUniqueVowels(String word, int k) {
        int subStringsCount = 0, n = word.length();
        var vowelSet = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        var vowelsInWindow = new HashMap<Character, Integer>();
        int windowEnd = 0, windowStart = 0;
        while (windowEnd < n) {
            char c = word.charAt(windowEnd);
            if (!vowelSet.contains(c)) {
                windowStart = windowEnd + 1;
                windowEnd++;
                vowelsInWindow.clear();
                continue;
            }
            vowelsInWindow.put(c, vowelsInWindow.getOrDefault(c, 0) + 1);
            windowEnd++;
            while (vowelsInWindow.size() > k) {
                c = word.charAt(windowStart);
                vowelsInWindow.put(c, vowelsInWindow.get(c) - 1);
                if (vowelsInWindow.get(c) == 0) {
                    vowelsInWindow.remove(c);
                }
                windowStart++;
            }

            subStringsCount += (windowEnd - windowStart + 1);
        }

        return subStringsCount;
    }
}
