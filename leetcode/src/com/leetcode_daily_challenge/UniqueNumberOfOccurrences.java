package com.leetcode_daily_challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        Map<Integer, Integer> elementOccurrenceCountMap = new HashMap<>();
        Set<Integer> uniqueElementOccurrenceSet = new HashSet<>();
        for (int element : arr) {
            elementOccurrenceCountMap.put(element, elementOccurrenceCountMap.getOrDefault(element, 0) + 1);
        }
        System.out.println(elementOccurrenceCountMap);
        for(int element : elementOccurrenceCountMap.keySet()){
            int elementOccurrence = elementOccurrenceCountMap.get(element);
            if(uniqueElementOccurrenceSet.contains(elementOccurrence)){
                return false;
            }
            uniqueElementOccurrenceSet.add(elementOccurrence);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueNumberOfOccurrences().uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
    }
}
