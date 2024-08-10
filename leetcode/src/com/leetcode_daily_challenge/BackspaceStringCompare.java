package com.leetcode_daily_challenge;

public class BackspaceStringCompare {
    private boolean backspaceCompare(String s, String t) {
        int sIndex = s.length() - 1;
        int tIndex = t.length() - 1;
        int sSkip = 0;
        int tSkip = 0;
        while (sIndex >= 0 || tIndex >= 0) {
            if (sIndex >= 0 && s.charAt(sIndex) == '#') {
                sSkip++;
                sIndex--;
                continue;
            }
            if (tIndex >= 0 && t.charAt(tIndex) == '#') {
                tSkip++;
                tIndex--;
                continue;
            }
            if (sSkip > 0) {
                sSkip--;
                sIndex--;
                continue;
            }
            if (tSkip > 0) {
                tSkip--;
                tIndex--;
                continue;
            }
            if (sIndex < 0 || tIndex < 0) {
                return false;
            }
            if (s.charAt(sIndex) != t.charAt(tIndex)) {
                return false;
            }
            sIndex--;
            tIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceStringCompare.backspaceCompare(s, t));
    }
}
