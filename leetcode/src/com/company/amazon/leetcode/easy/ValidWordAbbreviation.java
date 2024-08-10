package com.company.amazon.leetcode.easy;

public class ValidWordAbbreviation {
    private boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        // check if the abbreviation is same as word
        if (m == n && word.equals(abbr)) {
            return true;
        }
        /*
         * maintain two pointers for word and abbr, and iterate from left to right
         * it both characters are same then increment both pointers
         * else calculate the number from abbr and increment first pointer for number
         * times
         * return false whenever the above conditions fail
         */
        int wordPointer = 0, abbrPointer = 0;
        while (wordPointer < m && abbrPointer < n) {
            char wordChar = word.charAt(wordPointer);
            char abbrChar = abbr.charAt(abbrPointer);
            if (wordChar == abbrChar) {
                wordPointer++;
                abbrPointer++;
                continue;
            } else if (Character.isLetter(wordChar) && Character.isLetter(abbrChar) && wordChar != abbrChar) {
                return false;
            } else {
                int curValue = 0, totalValue = 0;
                while (abbrPointer < n && Character.isDigit(abbr.charAt(abbrPointer))) {
                    curValue = abbr.charAt(abbrPointer) - '0';
                    totalValue = totalValue * 10 + curValue;
                    if (curValue == 0 && totalValue == 0) {
                        return false;
                    }
                    abbrPointer++;
                }
                wordPointer = wordPointer + totalValue;
            }
        }
        return wordPointer == m && abbrPointer == n;
    }

    public static void main(String[] args) {
        ValidWordAbbreviation vAbbreviation = new ValidWordAbbreviation();
        System.out.println(vAbbreviation.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(vAbbreviation.validWordAbbreviation("apple", "a2e"));
        System.out.println(vAbbreviation.validWordAbbreviation("word", "3e"));
    }
}
