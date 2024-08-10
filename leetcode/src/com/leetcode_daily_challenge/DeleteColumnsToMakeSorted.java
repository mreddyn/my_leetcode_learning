package com.leetcode_daily_challenge;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int strsLength, strLength, sortCount;
        strsLength = strs.length;
        sortCount = 0;
        strLength = strs[0].length();
        for (int j = 0; j < strLength; j++) {
            char prevChar = strs[0].charAt(j);
            for (int i = 0; i < strsLength; i++) {
                char nextChar = strs[i].charAt(j);
                if (prevChar <= nextChar) {
                    prevChar = nextChar;
                    continue;
                } else {
                    sortCount++;
                    break;
                }
            }
        }
        return sortCount;
    }

    public static void main(String[] args) {
        System.out.println(new DeleteColumnsToMakeSorted().minDeletionSize(new String[] { "abc", "bce", "cae" }));
        System.out.println(new DeleteColumnsToMakeSorted().minDeletionSize(new String[] { "cba", "daf", "ghi" }));
        System.out.println(new DeleteColumnsToMakeSorted().minDeletionSize(new String[] { "zyx", "wvu", "tsr" }));
        System.out.println(new DeleteColumnsToMakeSorted().minDeletionSize(new String[] { "ab", "bc" }));
    }
}
