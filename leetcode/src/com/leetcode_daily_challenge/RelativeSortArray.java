package com.leetcode_daily_challenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        Map<Integer, Integer> relativeOrderMap = new HashMap<>();
        int relativeOrderIndex = 0;
        // Map the arr2 elements in a HashMap
        for (int i = 0; i < n; i++) {
            relativeOrderMap.put(arr2[i], relativeOrderIndex++);
        }

        Comparator<Integer> customComparator = new Comparator<>() {
            @Override
            public int compare(Integer firstElement, Integer secondElement) {
                int firstElementRelativeOrder = relativeOrderMap.getOrDefault(firstElement, -1);
                int secondElementRelativeOrder = relativeOrderMap.getOrDefault(secondElement, -1);
                if (firstElementRelativeOrder == -1 && secondElementRelativeOrder == -1) {
                    return firstElement - secondElement;
                } else if (firstElementRelativeOrder != -1 && secondElementRelativeOrder == -1) {
                    return -1;
                } else if (firstElementRelativeOrder == -1 && secondElementRelativeOrder != -1) {
                    return 1;
                } else {
                    return firstElementRelativeOrder - secondElementRelativeOrder;
                }
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(customComparator);
        for (int i = 0; i < m; i++) {
            pq.add(arr1[i]);
        }
        int arr1Index = 0;
        while (!pq.isEmpty()) {
            arr1[arr1Index++] = pq.poll();
        }
        return arr1;
    }

    public static void main(String[] args) {
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] result = relativeSortArray.relativeSortArray(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2,
                19 }, new int[] { 2, 1, 4, 3, 9, 6 });
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
