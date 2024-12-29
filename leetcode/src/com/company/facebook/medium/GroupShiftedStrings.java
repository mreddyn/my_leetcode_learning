package com.company.facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        /*
         * Find the internal pattern (abc => a-b c-b => 11)
         * create a hashMap with internal pattern as keys and strings as values
         * return the values of the hashMap
         */
        List<List<String>> res = new ArrayList<>();
        var map = new HashMap<String, List<String>>();
        for (String str : strings) {
            String hashKey = getHash(str);
            if (!map.containsKey(hashKey)) {
                map.put(hashKey, new ArrayList<>());
            }
            map.get(hashKey).add(str);
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private String getHash(String s) {
        var hashKey = new StringBuilder();
        int n = s.length();
        for (int i = 1; i < n; i++) {
            hashKey.append((((s.charAt(i) - s.charAt(i - 1)) + 26) % 26) + 'a');
        }
        return hashKey.toString();
    }
}
