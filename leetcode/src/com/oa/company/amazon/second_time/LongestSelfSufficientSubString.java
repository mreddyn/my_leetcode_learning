package com.oa.company.amazon.second_time;

import java.util.Arrays;

public class LongestSelfSufficientSubString {
    public int findLengthOfLongestSelfSufficientSubstring(String s) {
        int n = s.length();
        // Arrays to store first(-1 if not found) and last occurrence of each character
        int[] a = new int[26]; // first occurrence
        int[] b = new int[26]; // last occurrence

        // Initialize 'a' with -1 to indicate characters not yet found
        Arrays.fill(a, -1);

        // Fill 'a' and 'b'
        for (int i = 0; i < n; i++) {
            int j = s.charAt(i) - 'a';
            if (a[j] == -1) {
                a[j] = i;
            }
            b[j] = i;
        }

        int r = 0;
        // Check each character's interval
        for (int k = 0; k < 26; k++) {
            int startIndex = a[k];
            if (startIndex == -1) {
                // Character k does not appear in the string at all
                continue;
            }
            int maxIndex = b[k];
            // Expand the window [startIndex..j]
            for (int j = startIndex; j < n; j++) {
                int x = a[s.charAt(j) - 'a']; // first occurrence of s[j]
                int y = b[s.charAt(j) - 'a']; // last occurrence of s[j]
                // If there's a character whose first occurrence is < startIndex,
                // it means the substring won't be "self-sufficient"
                if (x < startIndex) {
                    break;
                }
                // Update the farthest needed index
                maxIndex = Math.max(maxIndex, y);

                // If we've covered the entire needed range and it's not the whole string
                if (maxIndex == j && (j - startIndex + 1) < n) {
                    r = Math.max(r, j - startIndex + 1);
                }
            }
        }

        return r;
    }

    public static void main(String[] args) {
        LongestSelfSufficientSubString obj = new LongestSelfSufficientSubString();
        System.out.println(obj.findLengthOfLongestSelfSufficientSubstring("amazonservices"));
    }
}
