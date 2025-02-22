package com.oa.company.wayfair;

import java.util.ArrayDeque;

public class RemoveAllAdjacentDuplicatesInStringTwo {
    public String removeDuplicates(String s, int k) {
        int n = s.length(), j = 0;
        var count = new ArrayDeque<Integer>();
        var ch = s.toCharArray();

        for (int i = 0; i < n; i++, j++) {
            ch[j] = ch[i];

            if (j == 0 || ch[j] != ch[j - 1]) {
                count.push(1);
            } else {
                // same adjacent char
                int incremented = count.pop() + 1;
                if (incremented == k) {
                    j -= k;
                } else {
                    count.push(incremented);
                }
            }
        }

        return new String(ch, 0, j);
    }
}
