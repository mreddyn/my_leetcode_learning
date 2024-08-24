package com.leetcode.easy;

public class MinimumNumberOfPushesToTypeWordOne {
    public int minimumPushes(String word) {
        /*
         * Since all chars in word are distinct, there will only be 26 chars at max.
         * We will arrange first 8 chars for 8 numbers each, then next 8 chars for 8
         * numbers each (press 2 times),
         * then remaining chars to 8 numbers each (press 3 times)
         */
        int n = word.length(), minPushes = 0;
        for (int i = 0; i < n; i++) {
            minPushes += 1 * ((i / 8) + 1);
        }
        return minPushes;
    }

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordOne mWordOne = new MinimumNumberOfPushesToTypeWordOne();
        System.out.println(mWordOne.minimumPushes("xycdefghij"));
    }
}
