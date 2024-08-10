package com.leetcode_contest.contest_312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        int n;
        n = heights.length;
        for(int i=0;i<n;i++){
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        for(int i=0;i<n;i++){
            names[n-1-i] = map.get(heights[i]);
        }
        for(String name : names){
            System.out.println(name);
        }
        return names;
    }
    public static void main(String[] args) {
        SortThePeople sortThePeople = new SortThePeople();
        sortThePeople.sortPeople(new String[]{"Mary","John","Emma"}, new int[]{180,165,170});
    }

}
