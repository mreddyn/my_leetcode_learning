package com.leetcode.easy;

public class MaximumValueOfaStringInAnArray {
    public int maximumValue(String[] strs) {
        int maxValue = 0;
        for (String s : strs) {
            int curValue = 0;
            if (isStringAlphanumeric(s)) {
                curValue = s.length();
            } else {
                curValue = Integer.parseInt(s, 10);
            }
            maxValue = Math.max(maxValue, curValue);

        }

        return maxValue;
    }

    private boolean isStringAlphanumeric(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }
}
