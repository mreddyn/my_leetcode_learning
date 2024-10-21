package com.company.rubrik.medium;

public class LongestSubStringWithAtleastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        return divideAndConquer(s, 0, s.length(), k);
    }

    private int divideAndConquer(String s, int start, int end, int k) {
        if (end - start < k) {
            // if substring length is shorter than k then return
            return 0;
        }

        // count frequency of each char in the string from start to end
        var map = new int[26];
        for (int i = start; i < end; i++) {
            map[s.charAt(i) - 'a']++;
        }

        // we will divide the current string if we encounter a character whose
        // frequency is less than k, as it will not contribute
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0 && map[i] < k) {
                // divide here
                for (int j = start; j < end; j++) {
                    // find out where is this character in the string
                    if (s.charAt(j) == i + 'a') {
                        int left = divideAndConquer(s, start, j, k);
                        int right = divideAndConquer(s, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }

        return end - start;
    }
}
