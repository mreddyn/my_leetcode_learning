package com.company.rubrik.medium;

public class FindLongestSpecialSubStringThatOccursThriceTwo {
    public int maximumLength(String s) {
        int res = -1, n = s.length();
        // check for all 26 characters
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int repeatedOnce = 0, repeatedTwice = 0, repeatedThrice = 0;
            // iterate over the string
            int i = 0;
            while (i < n) {
                if (ch == s.charAt(i)) {
                    int j = i, len = 0;
                    while (j < n && s.charAt(i) == s.charAt(j)) {
                        len++;
                        if (repeatedThrice < len) {
                            repeatedOnce = repeatedTwice;
                            repeatedTwice = repeatedThrice;
                            repeatedThrice = len;
                        } else if (repeatedTwice < len) {
                            repeatedOnce = repeatedTwice;
                            repeatedTwice = len;
                        } else if (repeatedOnce < len) {
                            repeatedOnce = len;
                        }
                        j++;
                    }
                    i = j;
                } else {
                    i++;
                }
            }
            res = Math.max(res, repeatedThrice);
        }

        return res;
    }
}
