package com.company.microsoft.leetcode;

public class LargestPalindromeNumber {
    private String largestPalindromic(String num) {
        int n = num.length();
        int[] freq = new int[10];
        // calculate digit frequencies
        for (int i = 0; i < n; i++) {
            freq[num.charAt(i) - '0']++;
        }
        /*
         * iterate from right
         * if odd frequency is found store it and decrease the count
         * if frequency of a digit is greater or equal to 2 then append and decrease the count by 2
         * if you are at 0th index and no digits in sb, then break since they will lead to zeros in front
         */
        boolean isOddPalindrome = false;
        char oddPalindromeDigit = '$';
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (!isOddPalindrome && freq[i] % 2 != 0) {
                isOddPalindrome = true;
                oddPalindromeDigit = (char) (i + '0');
                freq[i]--;
            }
            if(i == 0 && sb.length() == 0) {
                break;
            }
            while (freq[i] >= 2) {
                char c = (char) (i + '0');
                sb.append(c);
                freq[i] = freq[i] - 2;
            }
        }
        StringBuilder copy = new StringBuilder(sb.toString());
        if (isOddPalindrome) {
            sb.append(oddPalindromeDigit);
        }
        sb.append(copy.reverse().toString());
        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LargestPalindromeNumber largestPalindromeNumber = new LargestPalindromeNumber();
        System.out.println(largestPalindromeNumber.largestPalindromic("00009"));
    }
}
