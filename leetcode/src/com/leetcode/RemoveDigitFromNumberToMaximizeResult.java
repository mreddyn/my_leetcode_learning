package com.leetcode;

public class RemoveDigitFromNumberToMaximizeResult {
    private String removeDigit(String number, char digit) {
        int size = number.length(), index = 0;
        // remove the leftmost digit if it is followed by a bigger number, else delete last occurrence of digit
        for (int i = 0; i < size - 1; i++) {
            char c = number.charAt(i);
            if (c == digit && number.charAt(i+1) > c) {
                index = i;
                return removeCharacterAtIndex(number, index);
            }
        }
        index = number.lastIndexOf(digit);
        return removeCharacterAtIndex(number, index);
    }

    private String removeCharacterAtIndex(String number, int index) {
        int size = number.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i != index) {
                sb.append(number.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDigitFromNumberToMaximizeResult removeDigitFromNumberToMaximizeResult = new RemoveDigitFromNumberToMaximizeResult();
        System.out.println(removeDigitFromNumberToMaximizeResult.removeDigit("133235", '3'));
    }
}
