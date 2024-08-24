package com.leetcode.easy;

public class LexicographicallySmallestStringAfterSwap {
    public String getSmallestString(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length - 1; i++) {
            int firstDigit = ch[i] - '0';
            int secondDigit = ch[i + 1] - '0';
            if (ch[i] != ch[i + 1] && isSameParity(firstDigit, secondDigit) && firstDigit > secondDigit) {
                char c = ch[i + 1];
                ch[i + 1] = ch[i];
                ch[i] = c;
                break;
            }
        }

        return new String(ch);
    }

    private boolean isSameParity(int firstDigit, int secondDigit) {
        if (firstDigit % 2 == 0 && secondDigit % 2 == 0) {
            return true;
        }
        if (firstDigit % 2 != 0 && secondDigit % 2 != 0) {
            return true;
        }
        return false;
    }
}
