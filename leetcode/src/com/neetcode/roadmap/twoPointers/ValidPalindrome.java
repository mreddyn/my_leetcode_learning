package com.neetcode.roadmap.twoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        /*
         * Check if left pointer char is LetterOrDigit, if not continue by doing left++;
         * check if right pointer char LetterOrDigit, if not continue by doing right--;
         * now compare left pointer char and right pointer char by making them
         * lowercase,
         * if they are not equal then return false
         * if they are equal then do left++, and right--;
         */
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
