package com.company.microsoft.leetcode.medium;

public class IntegerToRoman {
    private static final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private static final String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public String intToRoman(int num) {
        var result = new StringBuilder();

        // loop through each symbol if num becomes zero
        for (int i = 0; i < values.length && num > 0; i++) {

            // repeat while the current number still fits into num
            while (values[i] <= num) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }
}
