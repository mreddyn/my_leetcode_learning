package com.leetcode_daily_challenge;

import java.util.Stack;

public class MakeTheStringGreat {
    private String makeGood(String s) {
        int n;
        char p, q;
        n = s.length();
        Stack<Character> a = new Stack<Character>();
        for (int i = n - 1; i >= 0; i--) {
            p = s.charAt(i);
            if (a.empty() == true) {
                a.push(p);
            } else {
                q = a.peek();
                if ((p + 32) == q || p == (q + 32)) {
                    a.pop();
                } else {
                    a.push(p);
                }
            }
        }
        n = a.size();
        char res[] = new char[n];
        for (int i = 0; i < n; i++) {
            res[i] = a.pop();
        }
        String str = new String(res);
        return str;
    }

    public static void main(String[] args) {
        MakeTheStringGreat makeTheStringGreat = new MakeTheStringGreat();
        System.out.println(makeTheStringGreat.makeGood("leEeetcode"));
    }
}
