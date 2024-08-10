package com.neetcode.roadmap.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    String delimiter = "/:";

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        /*
         * if we see a '/' we will add another '/' to it, and add delimiter to separate
         * the strings
         */
        for (String str : strs) {
            int n = str.length();
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '/') {
                    sb.append('/');
                }
                sb.append(str.charAt(i));
            }
            sb.append(delimiter);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        int i = 0, n = s.length();
        while (i < n) {
            if (i + 1 < n && s.charAt(i) == '/' && s.charAt(i + 1) == ':') {
                // if we see slash '/' followed by colon ':' then we just add it to the list
                decodedStrings.add(currentString.toString());
                currentString = new StringBuilder();
                i += 2;
            } else if (i + 1 < n && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                // if we see two slashes '//' then add a single slash and move on
                currentString.append('/');
                i += 2;
            } else {
                currentString.append(s.charAt(i));
                i++;
            }
        }
        
        return decodedStrings;
    }
}
