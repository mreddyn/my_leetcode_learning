package com.leetcode.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // if x is negative then return false
        if (x < 0) {
            return false;
        }

        // if last digit is 0 but the first is not zero then return false
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        // we will reverse the second half of the given number to
        // check if it is a palindrome of not
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + (x % 10);
            x = x / 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by
        // revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x =
        // 12,
        // revertedNumber = 123,
        // since the middle digit doesn't matter in palindrome(it will always equal to
        // itself), we
        // can simply get rid of it.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
