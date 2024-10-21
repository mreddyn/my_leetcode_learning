package com.company.rubrik.medium;

import java.util.HashMap;

public class FindLongestSpecialSubStringThatOccursThriceOne {
    public int maximumLength(String s) {
        int n = s.length(), res = -1;
        var map = new HashMap<String, Integer>();
        // Iterate over the string and count every substring
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String subStr = s.substring(i, j + 1);
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            }
        }

        System.out.println(map);
        // for all the strings in the map, check if a string has count>=3 and same chars
        for (String str : map.keySet()) {
            int freq = map.get(str);
            if (freq >= 3) {
                boolean flag = true;
                char ch = str.charAt(0);
                n = str.length();
                for (int j = 0; j < n; j++) {
                    if (str.charAt(j) != ch) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    res = Math.max(res, n);
                }
            }
        }

        return res;
    }
}
