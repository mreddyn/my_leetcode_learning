package com.leetcode.medium;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int maxVowelCount = 0, n = s.length(), curVowelCount = 0;
        // init a int array for vowel set
        var vowelSet = new int[] { 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 };

        for (int i = 0; i < n; i++) {
            // if current char is a vowel then increment the vowelCount
            curVowelCount += vowelSet[s.charAt(i) - 'a'];
            if (i >= k) {
                // decrement vowel count when the vowel goes out of window
                curVowelCount -= vowelSet[s.charAt(i - k) - 'a'];
            }

            maxVowelCount = Math.max(maxVowelCount, curVowelCount);
        }

        return maxVowelCount;
    }
}
