package com.leetcode;

public class StringCompression {
    private int compress(char[] chars) {
        int n = chars.length;
        if (n == 1) {
            return 1;
        }
        int index = n - 1;
        int curCharCount = 1;
        char curChar = chars[index];
        char prevChar = chars[index - 1];
        while (index > 0) {
            if (curChar == prevChar) {
                curCharCount++;
                chars[index] = ' ';
                curChar = prevChar;
            } else {
                if (curCharCount == 1) {
                    chars[index] = curChar;
                } else {
                    String count = String.valueOf(curCharCount);
                    chars[index] = curChar;
                    int decimalIndex = index + 1;
                    for (int i = 0; i < count.length(); i++) {
                        chars[decimalIndex] = count.charAt(i);
                        decimalIndex++;
                    }
                }
                curCharCount = 1;
                curChar = prevChar;
            }

            index--;
            prevChar = (index > 0) ? chars[index - 1] : ' ';
        }
        if (curCharCount > 1) {
            String count = String.valueOf(curCharCount);
            chars[index] = curChar;
            int decimalIndex = index + 1;
            for (int i = 0; i < count.length(); i++) {
                chars[decimalIndex] = count.charAt(i);
                decimalIndex++;
            }
        }
        int spaceCharStartIndex = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != ' ') {
                chars[spaceCharStartIndex++] = chars[i];
            }
        }

        return spaceCharStartIndex;
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression
                .compress(new char[] { 'a', 'a', 'a', 'b', 'b', 'a', 'a' }));
    }
}
