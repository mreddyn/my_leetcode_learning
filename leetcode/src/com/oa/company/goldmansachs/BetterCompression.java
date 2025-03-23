package com.oa.company.goldmansachs;

public class BetterCompression {
    public String betterCompression(String s) {
        /*
         * Consider a string, S, that is a series of characters, each followed by its
         * frequency as an integer. The string is not compressed correctly, so there may
         * be multiple occurrences of the same character. A properly compressed string
         * will consist of one instance of each character in alphabetical order followed
         * by the total count of that character within the string.
         */

        if (s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length();
        var map = new int[26];
        int index = 0;

        while (index < n) {
            char ch = s.charAt(index);
            int count = 0;
            index++;
            while (index < n && Character.isDigit(s.charAt(index))) {
                count = count * 10 + (s.charAt(index) - '0');
                index++;
            }
            map[ch - 'a'] += count;
        }

        var sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                sb.append((char) (i + 'a'));
                sb.append(map[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BetterCompression obj = new BetterCompression();
        System.out.println(obj.betterCompression("a3c9b2c1")); // a3b2c10
        System.out.println(obj.betterCompression("a3c9b2c1d2")); // a3b2c10d2
    }
}
