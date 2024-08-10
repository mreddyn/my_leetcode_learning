package com.leetcode.easy;

public class CheckIfAllAAppearBeforeB {
    public boolean checkString(String s) {
        int n = s.length(), aCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b' && i < aCount) {
                return false;
            }
        }

        return true;
    }

    public boolean checkStringApproachTwo(String s) {
        /*
         * Check if there is a substring 'ba' in the s.
         * If it exists then it confirms that b is coming before a ends, so return
         * false;
         */
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'a') {
                return false;
            }
        }

        return true;
    }
}
