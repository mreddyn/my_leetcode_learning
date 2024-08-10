package com.leetcode;

public class CountPrefixAndSuffixPairsOne {
    public int countPrefixSuffixPairs(String[] words) {
        int prefixAndSuffixPairsCount = 0, n = words.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String str1 = words[i];
                String str2 = words[j];
                if (isPrefixAndSuffix(str1, str2)) {
                    prefixAndSuffixPairsCount++;
                }
            }
        }

        return prefixAndSuffixPairsCount;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        int m = str1.length(), n = str2.length(), firstStrIndex, secondStrIndex;
        if (m > n) {
            return false;
        }

        // check prefix of str1 in str2 by char by char comparison
        firstStrIndex = secondStrIndex = 0;
        while (firstStrIndex < m && secondStrIndex < n && str1.charAt(firstStrIndex) == str2.charAt(secondStrIndex)) {
            firstStrIndex++;
            secondStrIndex++;
        }

        if (firstStrIndex != m) {
            return false;
        }

        // now check for suffix of str1 in str2
        firstStrIndex = m - 1;
        secondStrIndex = n - 1;
        while (firstStrIndex >= 0 && secondStrIndex >= 0 && str1.charAt(firstStrIndex) == str2.charAt(secondStrIndex)) {
            firstStrIndex--;
            secondStrIndex--;
        }

        return firstStrIndex == -1;
    }

    public static void main(String[] args) {
        CountPrefixAndSuffixPairsOne cAndSuffixPairsOne = new CountPrefixAndSuffixPairsOne();
        System.out.println(cAndSuffixPairsOne.countPrefixSuffixPairs(new String[] { "pa", "papa", "ma", "mama" }));
    }
}
