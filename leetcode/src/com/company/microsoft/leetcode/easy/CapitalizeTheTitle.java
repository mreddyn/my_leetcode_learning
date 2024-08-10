package com.company.microsoft.leetcode.easy;

public class CapitalizeTheTitle {
    public String capitalizeTitle(String title) {
        int n = title.length();
        char[] ch = title.toCharArray();
        for (int i = 0, j = 0; i <= n; i++) {
            if (i == n || ch[i] == ' ') {
                if ((i - j) > 2) {
                    // lowercase the word and Capitalize the first letter
                    lowercaseTheWord(ch, j, i);
                    ch[j] = Character.toUpperCase(ch[j]);
                } else {
                    // lowercase the word
                    lowercaseTheWord(ch, j, i);
                }
                j = i + 1;
            }
        }

        return new String(ch);
    }

    private void lowercaseTheWord(char[] ch, int start, int end) {
        for (int i = start; i < end; i++) {
            ch[i] = Character.toLowerCase(ch[i]);
        }
    }

    public static void main(String[] args) {
        CapitalizeTheTitle cTheTitle = new CapitalizeTheTitle();
        System.out.println(cTheTitle.capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(cTheTitle.capitalizeTitle("ST leTTeR of EACH Word"));
    }
}
