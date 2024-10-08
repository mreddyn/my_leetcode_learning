package com.leetcode.medium;

public class LongestSubstringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        int longestBeautifulStringLength = 0, n = word.length();
        int count = 1, windowStart = 0;
        for (int windowEnd = 1; windowEnd < n; windowEnd++) {
            if (word.charAt(windowEnd) > word.charAt(windowEnd - 1)) {
                // if the current char comes after the previous char the increase the count
                // i.e, we increase the window size
                count++;
            } else if (word.charAt(windowEnd) < word.charAt(windowEnd - 1)) {
                // if not reset the counter
                windowStart = windowEnd;
                count = 1;
            }

            if (count == 5) {
                // if the current window has all vowels then count its length
                longestBeautifulStringLength = Math.max(windowEnd - windowStart + 1, longestBeautifulStringLength);
            }
        }

        return longestBeautifulStringLength;
    }

    public static void main(String[] args) {
        LongestSubstringOfAllVowelsInOrder lInOrder = new LongestSubstringOfAllVowelsInOrder();
        System.out.println(lInOrder.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }
}
