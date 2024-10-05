package com.company.rubrik.easy;

import java.util.HashSet;

public class ExistenceOfASubstringInAStringAndItsReverse {
    public boolean isSubstringPresent(String s) {
        /*
         * maintain a set to store unique strings of s.
         * while iterating through the string, for each substring check if its reverse
         * already exists in set, if yes then return true.
         * else add the substring to the set.
         * Also in the substring if the firstChar and secondChar are same we can return
         * true.
         */
        int n = s.length();
        var substringSet = new HashSet<String>();

        for (int i = 0; i < n - 1; i++) {
            var substring = new char[] { s.charAt(i), s.charAt(i + 1) };
            var substringReverse = new char[] { s.charAt(i + 1), s.charAt(i) };
            if (s.charAt(i) == s.charAt(i + 1)) {
                return true;
            }

            if (substringSet.contains(new String(substringReverse))) {
                return true;
            }
            substringSet.add(new String(substring));
        }

        return false;
    }
}
