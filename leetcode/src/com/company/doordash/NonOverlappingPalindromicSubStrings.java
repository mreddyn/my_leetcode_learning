package com.company.doordash;

import java.util.ArrayList;

public class NonOverlappingPalindromicSubStrings {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        var intervals = new ArrayList<int[]>();

        // find odd length palindromes of length atleast k
        for (int center = 0; center < n; center++) {
            int left = center;
            int right = center;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len >= k) {
                    intervals.add(new int[] { left, right });
                }
                left--;
                right++;
            }
        }

        // find even length palindromes of length atleast k
        for (int center = 0; center < n - 1; center++) {
            int left = center;
            int right = center + 1;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len >= k) {
                    intervals.add(new int[] { left, right });
                }
                left--;
                right++;
            }
        }

        // sort intervals by end index
        intervals.sort((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int lastEnd = -1;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // if the current interval does not overlap with the last selected interval
            if (start > lastEnd) {
                count++;
                lastEnd = end;
            }
        }
        return count;
    }

}
