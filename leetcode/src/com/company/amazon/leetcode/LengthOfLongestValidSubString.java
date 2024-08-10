package com.company.amazon.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LengthOfLongestValidSubString {
    private int longestValidSubString(String word, List<String> forbidden) {
        int maxValidSubStringSize = 0, size = word.length();
        HashSet<String> forbiddenSet = new HashSet<>(forbidden);
        int r = size;
        // start from end
        for (int i = size - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < r && j < 10 + i; j++) {
                sb.append(word.charAt(j));
                // if string (ab) is invalid then all strings which end at 'ab' are invalid too
                // 
                /*
                 * e.g. for given word "cbaaaabc" with forbidden=["aaa","cb"]
                 * cb, cba, cbaa, cbaaa, .. are all invalid
                 * aaa, aaab, aaabc are invalid too
                 */
                // we reset the r where we encounter such string 
                if (forbiddenSet.contains(sb.toString())) {
                    r = j;
                    break;
                }
            }
            maxValidSubStringSize = Math.max(maxValidSubStringSize, r - i);
        }

        return maxValidSubStringSize;
    }

    public static void main(String[] args) {
        LengthOfLongestValidSubString lengthOfLongestValidSubString = new LengthOfLongestValidSubString();
        String word = "cbaaaabc";
        List<String> forbidden = Arrays.asList("aaa", "cb");
        System.out.println(lengthOfLongestValidSubString.longestValidSubString(word, forbidden));
    }
}
