package com.oa.company.wayfair;

import java.util.Map;

public class RomanNumeralsSorting {
    private Map<Character, Integer> romanToDecimal = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    private int getDecimalForRoman(String roman) {
        int decimal = 0;
        int prev = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int current = romanToDecimal.get(roman.charAt(i));

            if (current < prev) {
                decimal -= current;
            } else {
                decimal += current;
            }
            prev = current;
        }
        return decimal;
    }

    public String[] sortRomanNumerals(String[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (getDecimalForRoman(nums[i]) > getDecimalForRoman(nums[j])) {
                    String temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        var instance = new RomanNumeralsSorting();
        String[] nums = { "MCMIV", "MIV", "MCM", "MMIV" };
        String[] sorted = instance.sortRomanNumerals(nums);
        for (String num : sorted) {
            System.out.println(num);
        }
    }
}
