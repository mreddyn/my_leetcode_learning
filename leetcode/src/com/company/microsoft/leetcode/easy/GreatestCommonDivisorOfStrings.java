package com.company.microsoft.leetcode.easy;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        /*
         * Should there exist a string which divides both str1 and str2 then it should satisfy the 
         * transitive property str1+str2 == str2+str1
         * Also if any of the strings length is odd then return that string as gcd
         */
        int m = str1.length(), n = str2.length();
        String str1PlusStr2 = str1 + str2, str2PlusStr1 = str2 + str1;
        if (!str1PlusStr2.equals(str2PlusStr1)) {
            return "";
        }
        if (m % 2 == 1) {
            return str1;
        }
        if (n % 2 == 1) {
            return str2;
        }
        int gcdLength = gcd(m, n);
        String gcdString = str1.substring(0, gcdLength);

        return gcdString;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}
