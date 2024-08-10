package com.leetcode.easy;

public class ReplaceAllQuestionMarksToAvoidRepeatingChars {
    public String modifyString(String s) {
        int n = s.length();
        if (n == 1 && s.charAt(0) == '?') {
            return 'a' + "";
        }
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            // if currentChar is '?' then we need to replace with a char such it is not
            // equal to
            // any adjacent chars either left or right
            if (ch[i] != '?') {
                continue;
            }

            if (i == 0) {
                char nextChar = ch[i + 1];
                int replaceChar = 97;
                while ((char) replaceChar == nextChar) {
                    replaceChar++;
                }
                ch[i] = (char) replaceChar;

            } else if (i == n - 1) {
                char prevChar = ch[i - 1];
                int replaceChar = 97;
                while ((char) replaceChar == prevChar) {
                    replaceChar++;
                }
                ch[i] = (char) replaceChar;

            } else {
                char prevChar = ch[i - 1];
                char nextChar = ch[i + 1];
                int replaceChar = 97;
                while ((char) replaceChar == prevChar || (char) replaceChar == nextChar) {
                    replaceChar++;
                }
                ch[i] = (char) replaceChar;
            }
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        ReplaceAllQuestionMarksToAvoidRepeatingChars rChars = new ReplaceAllQuestionMarksToAvoidRepeatingChars();
        System.out.println(rChars.modifyString("ubv?w"));
    }
}
