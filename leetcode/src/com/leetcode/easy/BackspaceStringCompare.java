package com.leetcode.easy;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        if (type(s).equals(type(t))) {
            return true;
        }
        return false;
    }

    private String type(String s) {
        int n = s.length(), j = 0;
        var ch = s.toCharArray();
        for (int i = 0; i < n; i++, j++) {
            ch[j] = ch[i];
            if (j > 0 && ch[j] == '#') {
                j -= 2;
            }
        }
        // skip any # from the prefix of s
        int i = 0;
        while (i < j) {
            if (ch[i] != '#') {
                break;
            }
            i++;
        }
        return new String(ch, i, j-i);
    }

    public static void main(String[] args) {
        BackspaceStringCompare obj = new BackspaceStringCompare();
        System.out.println(obj.backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
