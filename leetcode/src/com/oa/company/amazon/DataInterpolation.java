package com.oa.company.amazon;

import java.util.*;

public class DataInterpolation {

    public static String getMinCostData(String data) {
        int n = data.length();
        char[] result = data.toCharArray();
        Set<Character> used = new HashSet<>();

        // Fill in the '?'
        for (int i = 0; i < n; i++) {
            if (result[i] == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (!used.contains(c)) {
                        result[i] = c;
                        used.add(c);
                        break;
                    }
                }
            } else {
                used.add(result[i]);
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(getMinCostData("aaaa?aaaa")); // Output: "aaaabaaaa"
        System.out.println(getMinCostData("??????")); // Output: "abcdef"
        System.out.println(getMinCostData("abcd?")); // Output: "abcde"
    }
}
