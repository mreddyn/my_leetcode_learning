package com.leetcode.easy;

public class CountSubstringsThatSatisfyKConstraint {
    public int countKConstraintSubstrings(String s, int k) {
        int satisfiedSubStringCount = 0, n = s.length();
        int windowEnd = 0, windowStart = 0, zerosCount = 0, onesCount = 0;
        while (windowEnd < n) {
            char windowEndChar = s.charAt(windowEnd);
            if (windowEndChar == '0') {
                zerosCount++;
            } else {
                onesCount++;
            }

            while (zerosCount > k && onesCount > k) {
                char windowStartChar = s.charAt(windowStart);
                if (windowStartChar == '0') {
                    zerosCount--;
                } else {
                    onesCount--;
                }
                windowStart++;
            }

            satisfiedSubStringCount += (windowEnd - windowStart + 1);
            windowEnd++;
        }

        return satisfiedSubStringCount;
    }
}
