package com.leetcode.medium;

public class StringCompression {
    public int compress(char[] chars) {
        int index = 0, ansIndex = 0, n = chars.length;
        while (index < n) {
            int count = 0;
            char currentChar = chars[index];
            while (index < n && currentChar == chars[index]) {
                count++;
                index++;
            }

            chars[ansIndex++] = currentChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[ansIndex++] = c;
                }
            }
        }

        return ansIndex;
    }

    public static void main(String[] args) {
        StringCompression sCompression = new StringCompression();
        System.out.println(sCompression.compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
    }
}
