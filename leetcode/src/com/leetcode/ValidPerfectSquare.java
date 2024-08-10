package com.leetcode;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num, product, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            product = mid * mid;
            if (product == num) {
                return true;
            }
            if (product < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
