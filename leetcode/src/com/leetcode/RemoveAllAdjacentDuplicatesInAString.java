package com.leetcode;

public class RemoveAllAdjacentDuplicatesInAString {
    public String removeDuplicates(String s) {
        /*
         * We will maintain two pointers, one to keep of current char in the iteration.
         * Other pointer to replace or overwrite when we encounter a duplicate.
         * We will copy the current char (j) into a char array at index (i).
         * and check for if i > 0 && ch[i] == ch[i-1], if it is then decrement by two places
         * else continue.
         */
        int n = s.length(), i = 0;
        char[] ch = s.toCharArray();
        for (int j = 0; j < n; j++, i++) {
            ch[i] = ch[j];
            if (i > 0 && ch[i] == ch[i - 1]) {
                i -= 2;
            }
        }
        return new String(ch, 0, i);
    }
}
