package com.oa.company.goldmansachs;

import java.util.HashMap;
import java.util.Map;

public class FindNumberOfDifferentWordsThatCanBeFormed {
    private Map<Integer, Integer> memo;

    public int numDifferentWords(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        memo = new HashMap<>();

        return decode(0, s);
    }

    private int decode(int index, String s) {
        if (index == s.length()) {
            return 1;
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        if (s.charAt(index) == '0') {
            // if the current character is 0, we can not decode because valid decoding does
            // not start with 0
            return 0;
        }

        int oneDigitWords = decode(index + 1, s);
        int twoDigitWords = 0;
        if (index + 1 < s.length()) {
            int twoDigitNumber = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigitNumber <= 26) {
                twoDigitWords = decode(index + 2, s);
            }
        }

        memo.put(index, oneDigitWords + twoDigitWords);

        return oneDigitWords + twoDigitWords;
    }

    public static void main(String[] args) {
        FindNumberOfDifferentWordsThatCanBeFormed obj = new FindNumberOfDifferentWordsThatCanBeFormed();
        String s = "123";
        System.out.println(obj.numDifferentWords(s)); // 3
        System.out.println(obj.numDifferentWords("10")); // 1
        System.out.println(obj.numDifferentWords("226")); // 3
        System.out.println(obj.numDifferentWords("0")); // 0
        System.out.println(obj.numDifferentWords("06")); // 0
        System.out.println(obj.numDifferentWords("2112")); // 5
    }
}
