package com.leetcode.easy;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        var ch = s.toCharArray();
        int n = ch.length, left = 0, right = n - 1;
        while (left < right) {
            if (!Character.isLetter(ch[left])) {
                left++;
                continue;
            }

            if (!Character.isLetter(ch[right])) {
                right--;
                continue;
            }
            var temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }

        return new String(ch);
    }
}
