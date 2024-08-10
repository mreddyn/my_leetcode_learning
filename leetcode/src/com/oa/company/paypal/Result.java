package com.oa.company.paypal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Result {
    private static int countPairs(List<Integer> projectCosts, int target) {
        int size = projectCosts.size(), pairs = 0;
        Collections.sort(projectCosts);
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int ele = projectCosts.get(i);
            int complement = Math.abs(target - ele);
            if (seen.contains(complement)) {
                pairs++;
            }
            seen.add(ele);
        }
        return pairs;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 3, 4, 2);
        int target = 2;
        System.out.println(countPairs(list, target));
    }
}
