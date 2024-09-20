package com.company.microsoft.leetcode.medium;

public class StringToInteger {
    public int myAtoi(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int index = 0;
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index == n) {
            return 0;
        }

        boolean isNegative = false;
        if (index < n) {

            if (s.charAt(index) == '-') {
                isNegative = true;
                index++;
            } else if (s.charAt(index) == '+') {
                index++;
            }

        }
        int result = 0;

        // iterate till digit
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // to avoid integer overflow
            // INT_MAX (maximum value) = 2,147,483,647
            // INT_MIN (minimum value) = -2,147,483,648
            if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && digit > 7)
                    || (result == (Integer.MIN_VALUE / 10) && digit > 8)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = (result * 10) + digit; // adding digits at their desired place-value

            index++;

        }

        return isNegative ? -result : result;
    }
}
