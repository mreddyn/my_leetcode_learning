package com.leetcode.easy;

public class ReverseStringTwo {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length, i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            reverseString(ch, i, j);
            i = i + 2 * k;
        }

        return new String(ch);
    }

    private void reverseString(char[] ch, int left, int right) {
        while (left < right) {
            char c = ch[left];
            ch[left] = ch[right];
            ch[right] = c;
            left++;
            right--;
        }
    }
}
