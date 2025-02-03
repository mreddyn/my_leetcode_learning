package com.oa.company.microsoft;

import java.util.HashMap;
import java.util.Map;

public class MinimumReplacementsToMakeStringBalanced {
    public static int solution(String row1, String row2) {
        // Convert to mutable arrays (since Java strings are immutable)
        char[] r1 = row1.toCharArray();
        char[] r2 = row2.toCharArray();

        int n = r1.length;
        if (r2.length != n) {
            // If the rows differ in length, that's invalid input for this logic.
            return -1;
        }

        // We'll keep track of how many 'R', 'W', and '?' are in each row.
        // mp1 = counts for row1; mp2 = counts for row2.
        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();
        mp1.put('R', 0);
        mp1.put('W', 0);
        mp1.put('?', 0);
        mp2.put('R', 0);
        mp2.put('W', 0);
        mp2.put('?', 0);

        int ans = 0; // total replacements

        for (int i = 0; i < n; i++) {
            // Check if column is invalid: both are R or both are W
            // In the original code, this leads to an immediate return -1.
            if ((r1[i] == 'R' && r2[i] == 'R') ||
                    (r1[i] == 'W' && r2[i] == 'W')) {
                return -1;
            }

            // If row1[i] = 'W' and row2[i] = '?', flip row2[i] to 'R'
            if (r1[i] == 'W' && r2[i] == '?') {
                r2[i] = 'R';
                ans++;
            }

            // If row1[i] = 'R' and row2[i] == '?', flip row2[i] to 'W'
            if (r1[i] == 'R' && r2[i] == '?') {
                r2[i] = 'W';
                ans++;
            }

            // If row2[i] = 'W' and row1[i] == '?', flip row1[i] to 'R'
            if (r2[i] == 'W' && r1[i] == '?') {
                r1[i] = 'R';
                ans++;
            }

            // If row2[i] = 'R' and row1[i] == '?', flip row1[i] to 'W'
            if (r2[i] == 'R' && r1[i] == '?') {
                r1[i] = 'W';
                ans++;
            }

            // Update counts for row1 and row2
            mp1.put(r1[i], mp1.getOrDefault(r1[i], 0) + 1);
            mp2.put(r2[i], mp2.getOrDefault(r2[i], 0) + 1);
        }

        // Now check the difference in #R and #W for row1 and row2
        int diff1 = Math.abs(mp1.get('R') - mp1.get('W'));
        int diff2 = Math.abs(mp2.get('R') - mp2.get('W'));

        // The original code insists these differences be equal and
        // that row1 has enough '?' to fix that difference. Then it
        // adds 2 * difference to ans and returns it.

        // (Potential logical issue: it only checks mp1['?'], ignoring mp2['?'],
        // and it doesn't confirm we can fix both rows. It's just the original logic.)

        if (diff1 == diff2 && mp1.get('?') >= diff1) {
            ans += 2 * diff1;
            return ans;
        }

        // If we can't fix the difference, return -1
        return -1;
    }

    // A simple driver
    public static void main(String[] args) {
        // Example usage:
        // Suppose row1 = "WR???", row2 = "R???W"
        // as in the original statement.
        // This is just a quick test:

        String row1 = "WR???";
        String row2 = "R???W";

        int result = solution(row1, row2);
        System.out.println("Result = " + result); // According to original code logic
    }

}
