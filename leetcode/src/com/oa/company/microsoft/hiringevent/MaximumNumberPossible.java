package com.oa.company.microsoft.hiringevent;

public class MaximumNumberPossible {
    public String maximumNumberPossible(String s, int k) {
        var str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c - 'a' < '5' && k > 0) {
                str.append('5');
                k--;
            } else {
                str.append(c);
            }
        }

        return str.toString();
    }
}
