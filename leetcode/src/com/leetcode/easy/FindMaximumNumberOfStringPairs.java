package com.leetcode.easy;

import java.util.HashSet;

public class FindMaximumNumberOfStringPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        var seen = new HashSet<String>();
        for (String word : words) {
            String reverse = getStringReverse(word);
            if (seen.remove(reverse)) {
                count++;
            } else {
                seen.add(word);
            }
        }

        return count;
    }

    private String getStringReverse(String s) {
        var sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
