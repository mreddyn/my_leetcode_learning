package com.oa.company.amazon;

import java.util.*;

public class RiceBags {

    public static int maxSetSize(int[] riceBags) {
        Arrays.sort(riceBags);
        int n = riceBags.length;
        Map<Integer, Integer> dp = new HashMap<>();
        int maxSize = -1;

        for (int i = 0; i < n; i++) {
            dp.put(riceBags[i], 1);
            for (int j = 0; j < i; j++) {
                if (riceBags[j] * riceBags[j] == riceBags[i]) {
                    dp.put(riceBags[i], Math.max(dp.get(riceBags[i]), dp.get(riceBags[j]) + 1));
                }
            }
            maxSize = Math.max(maxSize, dp.get(riceBags[i]));
        }

        return maxSize >= 2 ? maxSize : -1;
    }

    public static void main(String[] args) {
        int[] riceBags1 = { 625, 4, 2, 5, 25 };
        int[] riceBags2 = { 3, 9, 4, 2, 16 };

        System.out.println(maxSetSize(riceBags1)); // Output: 3
        System.out.println(maxSetSize(riceBags2)); // Output: 3
    }
}
