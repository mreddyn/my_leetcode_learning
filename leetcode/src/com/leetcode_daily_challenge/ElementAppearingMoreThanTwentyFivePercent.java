package com.leetcode_daily_challenge;

public class ElementAppearingMoreThanTwentyFivePercent {
    private int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        int quarter = n / 4;
        int count = 1;
        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == prev) {
                count++;
                if (count > quarter) {
                    return prev;
                }
            } else {
                count = 1;
                prev = arr[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ElementAppearingMoreThanTwentyFivePercent e = new ElementAppearingMoreThanTwentyFivePercent();
        int[] arr = { 1, 2, 2, 6, 6, 6, 6, 7, 10 };
        System.out.println(e.findSpecialInteger(arr));
    }
}
