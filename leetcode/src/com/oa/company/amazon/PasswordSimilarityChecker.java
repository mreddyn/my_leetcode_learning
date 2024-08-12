package com.oa.company.amazon;

import java.util.ArrayList;
import java.util.List;

public class PasswordSimilarityChecker {

    public static List<String> checkSimilarPasswords(String[] newPasswords, String[] oldPasswords) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < newPasswords.length; i++) {
            String newPassword = newPasswords[i];
            String oldPassword = oldPasswords[i];

            if (isSubsequence(newPassword, oldPassword)) {
                results.add("YES");
            } else {
                results.add("NO");
            }
        }

        return results;
    }

    private static boolean isSubsequence(String newPassword, String oldPassword) {
        int newLen = newPassword.length();
        int oldLen = oldPassword.length();

        int j = 0; // pointer for oldPassword

        for (int i = 0; i < newLen && j < oldLen; i++) {
            // If characters match or the next cyclic character matches
            if (newPassword.charAt(i) == oldPassword.charAt(j) ||
                    nextCyclicChar(newPassword.charAt(i)) == oldPassword.charAt(j)) {
                j++;
            }
        }

        // If j reached the end of oldPassword, it means oldPassword is a subsequence
        return j == oldLen;
    }

    private static char nextCyclicChar(char ch) {
        if (ch == 'z') {
            return 'a';
        }
        return (char) (ch + 1);
    }

    public static void main(String[] args) {
        String[] newPasswords1 = { "baacbab", "accdb", "baacba" };
        String[] oldPasswords1 = { "abdbc", "ach", "abb" };
        System.out.println(checkSimilarPasswords(newPasswords1, oldPasswords1)); // Output: [YES, NO, YES]

        String[] newPasswords2 = { "aaccbbee", "aab" };
        String[] oldPasswords2 = { "bdbf", "aee" };
        System.out.println(checkSimilarPasswords(newPasswords2, oldPasswords2)); // Output: [YES, NO]
    }
}
