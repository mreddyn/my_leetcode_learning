package com.company.facebook.easy;

public class AlternatingGroupsOne {
    public int numberOfAlternatingGroups(int[] colors) {
        int alternatingGroupsCount = 0, n = colors.length;

        for (int i = 0; i < n; i++) {
            // we need to check the group size of 3 if it is alternative or not
            // only two case 101 or 010
            if (colors[i] == 0 && colors[(i + 1) % n] == 1 && colors[(i + 2) % n] == 0) {
                alternatingGroupsCount++;
            } else if (colors[i] == 1 && colors[(i + 1) % n] == 0 && colors[(i + 2) % n] == 1) {
                alternatingGroupsCount++;
            }
        }

        return alternatingGroupsCount;
    }
}
