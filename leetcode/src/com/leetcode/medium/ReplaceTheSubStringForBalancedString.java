package com.leetcode.medium;

public class ReplaceTheSubStringForBalancedString {
    public int balancedString(String s) {
        int n = s.length(), res = n, k = n / 4;
        var map = new int[128];
        for (int i = 0; i < n; i++) {
            map[s.charAt(i)]++;
        }

        for (int end = 0, start = 0; end < n; end++) {
            // add the current char to window (i.e removing character from outside)
            map[s.charAt(end)]--;

            // check if removing this character from outside to see if the string is still
            // balanced
            while (start < n && map['Q'] <= k && map['W'] <= k && map['E'] <= k && map['R'] <= k) {
                res = Math.min(res, end - start + 1);
                map[s.charAt(start)]++;
                start++;
            }
        }

        return res;
    }
}
