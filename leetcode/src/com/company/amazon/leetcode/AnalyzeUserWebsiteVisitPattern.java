package com.company.amazon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnalyzeUserWebsiteVisitPattern {
    private List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, List<CustomPair>> map = new HashMap<>();
        // collect the website info for every user
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new CustomPair(timestamp[i], website[i]));
        }

        // map to keep track of 3-sequence
        Map<String, Integer> count = new HashMap<>();
        String res = "";
        for (String key : map.keySet()) {
            Set<String> seen = new HashSet<>();
            List<CustomPair> list = map.get(key);
            // sort by time
            Collections.sort(list, (a, b) -> (a.timestamp - b.timestamp));
            int size = list.size();
            for (int i = 0; i < size - 2; i++) {
                for (int j = i + 1; j < size - 1; j++) {
                    for (int k = j + 1; k < size; k++) {
                        String str = list.get(i).website + " " + list.get(j).website + " " + list.get(k).website;
                        if (!seen.contains(str)) {
                            count.put(str, count.getOrDefault(str, 0) + 1);
                            seen.add(str);
                        }

                        if (res.equals("") || count.get(res) < count.get(str)
                                || (count.get(res) == count.get(str) && res.compareTo(str) > 0)) {
                            res = str;
                        }
                    }
                }
            }
        }
        return Arrays.asList(res.split(" "));
    }

    class CustomPair {
        String website;
        int timestamp;

        CustomPair(int timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public static void main(String[] args) {
        AnalyzeUserWebsiteVisitPattern analyzeUserWebsiteVisitPattern = new AnalyzeUserWebsiteVisitPattern();
        analyzeUserWebsiteVisitPattern.mostVisitedPattern(new String[] {}, null, new String[] {});
    }
}
