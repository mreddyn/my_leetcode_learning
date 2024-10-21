package com.oa.company.oracle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecodeString {
    public static List<Integer> frequency(String s) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(26, 0)); // Initialize list with 26 zeros
        int n = s.length();
        int i = 0;

        while (i < n) {
            // Check if the current character is part of a two-digit encoding (10# to 26#)
            if (i + 2 < n && s.charAt(i + 2) == '#') {
                // Extract the number for 10# to 26#
                int num = Integer.parseInt(s.substring(i, i + 2));
                i += 3; // Move past the "num#"

                // Check if this character has a count (like '11#(2)')
                if (i < n && s.charAt(i) == '(') {
                    int countStart = ++i;
                    while (s.charAt(i) != ')')
                        i++;
                    int count = Integer.parseInt(s.substring(countStart, i));
                    result.set(num - 1, result.get(num - 1) + count); // Add count to the appropriate letter
                    i++; // Move past ')'
                } else {
                    result.set(num - 1, result.get(num - 1) + 1); // Default count is 1
                }
            } else {
                // Single-digit encoding (1 to 9)
                int num = s.charAt(i) - '0';
                i++; // Move to the next character

                // Check if this character has a count (like '1(2)')
                if (i < n && s.charAt(i) == '(') {
                    int countStart = ++i;
                    while (s.charAt(i) != ')')
                        i++;
                    int count = Integer.parseInt(s.substring(countStart, i));
                    result.set(num - 1, result.get(num - 1) + count);
                    i++; // Move past ')'
                } else {
                    result.set(num - 1, result.get(num - 1) + 1);
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(frequency("abzx"));
    }

}
