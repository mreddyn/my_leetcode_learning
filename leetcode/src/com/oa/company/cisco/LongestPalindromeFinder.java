package com.oa.company.cisco;

public class LongestPalindromeFinder {

    public static void main(String[] args) {
        // Example usage:
        System.out.println(findLongestPalindromicSubstring("YABCBAZ")); // should print "ABCBA"
        System.out.println(findLongestPalindromicSubstring("ABC")); // should print "None"
        System.out.println(findLongestPalindromicSubstring("ABCABA")); // should print "None"
    }

    public static String findLongestPalindromicSubstring(String s) {
        // Edge case: if string is null or length < 2, no palindrome of length > 1
        if (s == null || s.length() < 2) {
            return "None";
        }

        String bestPalindrome = "";

        for (int center = 0; center < s.length(); center++) {
            // 1) Odd length palindromes (center at [center, center])
            String oddPal = expandAroundCenter(s, center, center);
            bestPalindrome = updateBest(bestPalindrome, oddPal);

            // 2) Even length palindromes (center at [center, center+1])
            String evenPal = expandAroundCenter(s, center, center + 1);
            bestPalindrome = updateBest(bestPalindrome, evenPal);
        }

        // If we never found a palindrome of length > 1, return "None"
        return (bestPalindrome.length() > 1) ? bestPalindrome : "None";
    }

    // Expand outward while characters at left and right match
    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // substring boundaries: [left+1, right) because we expanded one step too far
        return s.substring(left + 1, right);
    }

    // Compare new palindrome candidate with the best so far
    private static String updateBest(String best, String candidate) {
        // If candidate is strictly longer, or same length but lexicographically smaller
        if (candidate.length() > best.length()) {
            return candidate;
        } else if (candidate.length() == best.length() && candidate.compareTo(best) < 0) {
            return candidate;
        }
        return best;
    }
}
