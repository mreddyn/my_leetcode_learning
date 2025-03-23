package com.oa.company.goldmansachs;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int even = palindromicCount(s, i, i + 1);
            int odd = palindromicCount(s, i - 1, i + 1);
            res += even + odd + 1;
        }
        return res;
    }

    private int palindromicCount(String s, int left, int right) {
        int count = 0;
        int n = s.length();
        while (left >= 0 && right < n) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
