package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumOperationsToMakeASpecialNumber {
    private int minimumOperations(String num) {
        int size = num.length(), operations = Integer.MAX_VALUE;
        if (num.contains("0")) {
            operations = size - 1;
        }
        // check for last digits match with 00, 25, 50, or 75
        HashSet<String> set = new HashSet<>(Arrays.asList("00", "25", "50", "75"));
        char ch[] = new char[2];
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                ch[0] = num.charAt(i);
                ch[1] = num.charAt(j);
                String multiple = new String(ch);
                if (set.contains(multiple)) {
                    operations = Math.min(operations, size - 2 - i);
                }
            }
        }
        operations = (operations == Integer.MAX_VALUE) ? size : operations;
        return operations;
    }

    private int minimumOperationsApproachTwo(String num) {
        boolean fiveFound = false, zeroFound = false;
        int size = num.length();
        for (int i = size - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (zeroFound && c == '5') {
                return size - 2 - i;
            }
            if (zeroFound && c == '0') {
                return size - 2 - i;
            }
            if (fiveFound && c == '2') {
                return size - 2 - i;
            }
            if (fiveFound && c == '7') {
                return size - 2 - i;
            }
            if (c == '5') {
                fiveFound = true;
            }
            if (c == '0') {
                zeroFound = true;
            }
        }
        if (zeroFound) {
            return size - 1;
        }
        return size;

    }

    public static void main(String[] args) {
        MinimumOperationsToMakeASpecialNumber minimumOperationsToMakeASpecialNumber = new MinimumOperationsToMakeASpecialNumber();
        System.out.println(minimumOperationsToMakeASpecialNumber.minimumOperations("2245047"));
        System.out.println(minimumOperationsToMakeASpecialNumber.minimumOperationsApproachTwo("2245047"));
    }
}
