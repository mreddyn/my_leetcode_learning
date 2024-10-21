package com.company.rubrik.medium;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int longestSubString = 0, n = s.length();
        var seen = new HashSet<Character>();
        for (int windowEnd = 0, windowStart = 0; windowEnd < n; windowEnd++) {
            while (seen.contains(s.charAt(windowEnd))) {
                seen.remove(s.charAt(windowStart));
                windowStart++;
            }

            seen.add(s.charAt(windowEnd));
            longestSubString = Math.max(longestSubString, windowEnd - windowStart + 1);
        }

        return longestSubString;
    }

    public int lengthOfLongestSubstringApproachTwo(String s) {
        int longestSubString = 0, n = s.length();
        var seen = new int[128];
        for (int windowEnd = 0, windowStart = 0; windowEnd < n; windowEnd++) {
            while (seen[s.charAt(windowEnd)] > 0) {
                seen[s.charAt(windowStart)]--;
                windowStart++;
            }

            seen[s.charAt(windowEnd)]++;
            longestSubString = Math.max(longestSubString, windowEnd - windowStart + 1);
        }
        return longestSubString;
    }
}
