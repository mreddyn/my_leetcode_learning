package com.company.doordash;

import java.util.HashSet;
import java.util.Set;

public class TwoStringsSwap {
    public Set<String> getSimilarRestaurants(String target, String[] restaurants) {
        var res = new HashSet<String>();

        for (String restaurant : restaurants) {
            if (isSimilar(target, restaurant)) {
                res.add(restaurant);
            }
        }

        return res;
    }

    private boolean isSimilar(String target, String restaurant) {
        if (target.length() != restaurant.length()) {
            return false;
        }

        if (target.equals(restaurant)) {
            var count = new int[26];
            for (int i = 0; i < target.length(); i++) {
                count[target.charAt(i) - 'a']++;

                if (count[target.charAt(i) - 'a'] == 2) {
                    return true;
                }
            }

            return false;
        }

        int diff = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != restaurant.charAt(i)) {
                diff++;
            }
        }

        return diff == 2;
    }

    public static void main(String[] args) {
        TwoStringsSwap twoStringsSwap = new TwoStringsSwap();
        String[] strs = { "hottop", "hotopt", "hotpit", "httoop", "hptoot", "hotozt" };
        System.out.println(twoStringsSwap.getSimilarRestaurants("hotpot", strs));
    }
}
