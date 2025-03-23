package com.oa.company.goldmansachs;

import java.util.HashMap;

public class ProjectEstimates {
    public int countPairs(int n, int[] projectCosts, int target) {
        /*
         * A number of bids are being taken for a project. Determine the number of
         * distinct pairs of project costs where their absolute difference is some
         * target value. Two pairs are distinct if they differ in at least one value.
         */
        int count = 0;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int diff1 = projectCosts[i] - target;
            int diff2 = projectCosts[i] + target;
            count += map.getOrDefault(diff1, 0) + map.getOrDefault(diff2, 0);
            map.put(projectCosts[i], map.getOrDefault(projectCosts[i], 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        ProjectEstimates obj = new ProjectEstimates();
        int n = 5;
        int[] projectCosts = { 1, 5, 3, 4, 2 };
        int target = 2;
        System.out.println(obj.countPairs(n, projectCosts, target)); // 3
    }
}
