package com.leetcode.medium;

import java.util.HashMap;

public class NumberOfUniqueFlavorsAfterSharingKCandies {
    public int shareCandies(int[] candies, int k) {
        int maxFlavorCount = 0, n = candies.length;
        // map to keep track of candy type and candy freq
        var map = new HashMap<Integer, Integer>();
        for (int candy : candies) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }

        for (int end = 0, start = 0; end < n; end++) {
            // add the candy to window
            map.put(candies[end], map.get(candies[end]) - 1);
            map.remove(candies[end], 0);

            if (end >= k) {
                // when sliding the window, remove the candy from window that goes out of
                // boundary
                map.put(candies[start], map.getOrDefault(candies[start], 0) + 1);
                start++;
            }

            if (end >= k - 1) {
                maxFlavorCount = Math.max(maxFlavorCount, map.size());
            }
        }

        return maxFlavorCount;
    }
}
