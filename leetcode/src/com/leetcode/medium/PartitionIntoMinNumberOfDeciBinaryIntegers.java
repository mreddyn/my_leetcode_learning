package com.leetcode.medium;

public class PartitionIntoMinNumberOfDeciBinaryIntegers {
    public int minPartitions(String n) {
        int maxDigit = 0, len = n.length();
        for (int i = 0; i < len; i++) {
            maxDigit = Math.max(maxDigit, n.charAt(i) - '0');
        }
        return maxDigit;
    }
}
