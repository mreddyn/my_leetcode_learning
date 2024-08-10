package com.leetcode.easy;

public class CountLargestGroup {
    public int countLargestGroup(int n) {
        int largestGroupCount = 0, maxGroup = 0;
        int[] map = new int[10001];
        for (int i = 1; i <= n; i++) {
            int digitSum = digitSum(i);
            map[digitSum]++;
        }

        for (int i = 1; i < 10001; i++) {
            maxGroup = Math.max(maxGroup, map[i]);
        }

        for (int i = 1; i < 10001; i++) {
            if (map[i] == maxGroup) {
                largestGroupCount++;
            }
        }

        return largestGroupCount;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num = num / 10;
        }
        return sum;
    }
}
