package com.leetcode_contest.contest_417;

import java.util.Arrays;
import java.util.HashSet;

public class CountOfSubStringsContainingEveryVowelAndKConsonantsOne {
    public int countOfSubstrings(String word, int k) {
        /*
         * Below solution is brute force.
         * For a better approach we need sliding window.
         * Maintain a window for size (5+k), if this window satisfies condition then the
         * number of substrings are n-index.
         * now slide the window by one char (add next char and remove the first char).
         */
        int n = word.length(), subStringsCount = 0;
        if (n < 5 + k) {
            return 0;
        }
        var vowelSet = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int start = 0; start < n; start++) {
            var vowelsInWindow = new HashSet<Character>();
            int consonantCount = 0;

            for (int end = start; end < n; end++) {
                char c = word.charAt(end);

                if (vowelSet.contains(c)) {
                    vowelsInWindow.add(c);
                } else {
                    consonantCount++;
                }

                if (vowelsInWindow.size() == 5 && consonantCount == k) {
                    subStringsCount++;
                }

                if (consonantCount > k) {
                    break;
                }
            }
        }

        return subStringsCount;
    }

    public static void main(String[] args) {
        CountOfSubStringsContainingEveryVowelAndKConsonantsOne cOne = new CountOfSubStringsContainingEveryVowelAndKConsonantsOne();
        System.out.println(cOne.countOfSubstrings("auieoui", 0));
        System.out.println(cOne.countOfSubstrings("ieaouqqieaouqq", 1));
        System.out.println(cOne.countOfSubstrings("aeioqq", 1));
    }
}
