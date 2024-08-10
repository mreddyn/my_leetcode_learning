package com.leetcode;

import java.util.Arrays;

public class HIndex {
    private int hIndex(int[] citations) {
        int index = 0, n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[n - 1 - i] > i) {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex(new int[] { 1, 1, 3 }));
    }
}
