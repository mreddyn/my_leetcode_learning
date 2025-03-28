package com.oa.company.microsoft.hiringevent;

import java.util.Arrays;

public class CountCharactersBeforeUppercase {
    public int countCharactersBeforeUppercase(String s) {
        /*
         * Given a string of letters, containing both uppercase and lowercase letters,
         * return the number of different characters where all lowercase of that
         * character appear before any uppercase letter.
         */
        var upperCharLeftmostIndex = new int[26];
        var lowerCharRightmostIndex = new int[26];
        Arrays.fill(upperCharLeftmostIndex, -1);
        Arrays.fill(lowerCharRightmostIndex, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                int idx = c - 'A';
                if (upperCharLeftmostIndex[idx] == -1) {
                    upperCharLeftmostIndex[idx] = i;
                }
            } else {
                int idx = c - 'a';
                lowerCharRightmostIndex[idx] = i;
            }
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (upperCharLeftmostIndex[i] != -1 && lowerCharRightmostIndex[i] != -1
                    && lowerCharRightmostIndex[i] < upperCharLeftmostIndex[i]) {
                res++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        var obj = new CountCharactersBeforeUppercase();
        System.out.println(obj.countCharactersBeforeUppercase("aaAbcCABBc"));
        System.out.println(obj.countCharactersBeforeUppercase("aaAbcCABBcdDabd"));
    }
}
