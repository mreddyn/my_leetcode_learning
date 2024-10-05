package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        var seen = new HashSet<String>();
        var repeated = new HashSet<String>();
        // Iterate over all substrings of length 10
        for (int i = 0; i + 9 < n; i++) {
            String sequence = s.substring(i, i + 10);
            // if we already seen a sequence then add it to repeated set
            if (!seen.add(sequence)) {
                repeated.add(sequence);
            }
        }

        return new ArrayList<>(repeated);
    }
}
