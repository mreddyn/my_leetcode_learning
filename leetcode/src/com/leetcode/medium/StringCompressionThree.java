package com.leetcode.medium;

public class StringCompressionThree {
    private final int MAX_PREFIX_LENGTH = 9;

    public String compressedString(String word) {
        int n = word.length(), index = 0;
        var comp = new StringBuilder();
        while (index < n) {
            int count = 0;
            char currentChar = word.charAt(index);
            while (index < n && currentChar == word.charAt(index) && count < MAX_PREFIX_LENGTH) {
                index++;
                count++;
            }

            comp.append(count);
            comp.append(currentChar);

        }

        return comp.toString();
    }
}
