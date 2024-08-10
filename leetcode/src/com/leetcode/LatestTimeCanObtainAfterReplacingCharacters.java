package com.leetcode;

public class LatestTimeCanObtainAfterReplacingCharacters {
    private String findLatestTime(String s) {
        char[] ch = s.toCharArray();
        if (ch[0] == '?' && ch[1] == '?') {
            ch[0] = '1';
            ch[1] = '1';
        } else if (ch[0] == '?' && ch[1] != '?') {
            if (ch[1] == '1' || ch[1] == '0') {
                ch[0] = '1';
            } else {
                ch[0] = '0';
            }
        } else if (ch[0] != '?' && ch[1] == '?') {
            if (ch[0] == '1') {
                ch[1] = '1';
            } else {
                ch[1] = '9';
            }
        }
        if (ch[3] == '?' && ch[4] == '?') {
            ch[3] = '5';
            ch[4] = '9';
        } else if (ch[3] == '?' && ch[4] != '?') {
            ch[3] = '5';
        } else if (ch[3] != '?' && ch[4] == '?') {
            ch[4] = '9';
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        LatestTimeCanObtainAfterReplacingCharacters latestTimeCanObtainAfterReplacingCharacters = new LatestTimeCanObtainAfterReplacingCharacters();
        System.out.println(latestTimeCanObtainAfterReplacingCharacters.findLatestTime("1?:?4"));
    }
}
