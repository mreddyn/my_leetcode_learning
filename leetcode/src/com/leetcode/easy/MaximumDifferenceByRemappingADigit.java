package com.leetcode.easy;

public class MaximumDifferenceByRemappingADigit {
    public int minMaxDifference(int num) {
        int maxDiff = 0;
        char[] charNumForMaxRemapping = String.valueOf(num).toCharArray();
        char[] charNumForMinRemapping = String.valueOf(num).toCharArray();

        int n = charNumForMaxRemapping.length;
        char remappedDigitForMaxValue = '0', remappedDigitForMinValue = charNumForMaxRemapping[0];
        for (int i = 0; i < n; i++) {
            // get the first non-nine digit for remapping
            if (charNumForMaxRemapping[i] != '9') {
                remappedDigitForMaxValue = charNumForMaxRemapping[i];
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            // remapping all matching chars to '9' for max value
            if (charNumForMaxRemapping[i] == remappedDigitForMaxValue) {
                charNumForMaxRemapping[i] = '9';
            }
        }

        for (int i = 0; i < n; i++) {
            // since num does not contain leading zeros we can just convert first non-zero
            // char to zeros
            // remapping all matching chars to '0' for min value
            if (charNumForMinRemapping[i] == remappedDigitForMinValue) {
                charNumForMinRemapping[i] = '0';
            }
        }

        maxDiff = Integer.parseInt(new String(charNumForMaxRemapping))
                - Integer.parseInt(new String(charNumForMinRemapping));

        return maxDiff;
    }
}
