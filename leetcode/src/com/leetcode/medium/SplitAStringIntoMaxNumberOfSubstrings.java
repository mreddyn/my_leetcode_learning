package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class SplitAStringIntoMaxNumberOfSubstrings {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> seen) {
        if (start >= s.length()) {
            // if we reach end of substring then we can return 0,
            // as no more substrings to add
            return 0;
        }

        int maxCount = 0, n = s.length();

        // try every possible substring starting from start
        for (int end = start + 1; end <= n; end++) {
            String subString = s.substring(start, end);

            // if the substring is unique
            if (!seen.contains(subString)) {
                seen.add(subString);
                // recursively count the remaining substrings starting from start
                maxCount = Math.max(maxCount, 1 + backtrack(s, end, seen));

                // remove the current substring from set
                seen.remove(subString);
            }
        }
        return maxCount;
    }
}
