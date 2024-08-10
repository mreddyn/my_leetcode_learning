package com.leetcode_daily_challenge;

import java.util.Arrays;
import java.util.Comparator;

public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {

        int n = heights.length;
        Pair[] nameHeightPairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            nameHeightPairs[i] = new Pair(names[i], heights[i]);
        }
        Comparator<Pair> customComparator = new Comparator<SortThePeople.Pair>() {
            @Override
            public int compare(Pair pairOne, Pair pairTwo) {
                return pairTwo.height - pairOne.height;
            }
        };
        Arrays.sort(nameHeightPairs, customComparator);
        for (int i = 0; i < n; i++) {
            names[i] = nameHeightPairs[i].name;
        }
        return names;
    }

    class Pair {
        String name;
        int height;

        Pair(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}
