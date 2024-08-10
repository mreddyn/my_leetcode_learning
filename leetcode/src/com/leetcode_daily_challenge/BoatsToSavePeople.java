package com.leetcode_daily_challenge;

import java.util.Arrays;

public class BoatsToSavePeople {
    private int numRescueBoats(int[] people, int limit) {
        int boats = 0, n = people.length;
        int leftPointer = 0, rightPointer = n - 1;
        Arrays.sort(people);
        while (leftPointer < rightPointer) {
            int weight = people[leftPointer] + people[rightPointer];
            if (weight <= limit) {
                leftPointer++;
                rightPointer--;
                boats++;
            } else {
                rightPointer--;
                boats++;
            }
        }
        if (leftPointer == rightPointer) {
            boats++;
        }

        return boats;
    }

    private int numRescueBoatsApproachTwo(int[] people, int limit) {
        /*
         * We can see the main cost for this logic is the Arrays.sort(). After seeing
         * the hint "It is guaranteed each person can be carried by a boat", we know
         * that the number in the array will not be larger than limit; Hence, it is
         * suitable for bucket sort. Once we sort the array, the remain logic is the
         * same. The only difference is that we need make sure start and end are
         * pointing to a valid person, since the bucket might be 0;
         */
        int boats = 0, n = people.length;
        int[] buckets = new int[limit + 1];
        for (int i = 0; i < n; i++) {
            buckets[people[i]]++;
        }
        int start = 0, end = buckets.length - 1;
        while (start <= end) {
            // if there are no people just skip the bucket
            while (start <= end && buckets[start] <= 0) {
                start++;
            }
            // if there are no people just skip the bucket
            while (start <= end && buckets[end] <= 0) {
                end--;
            }
            if (buckets[start] <= 0 && buckets[end] <= 0) {
                break;
            }
            boats++;
            if (start + end <= limit) {
                buckets[start]--;
            }
            buckets[end]--;
        }
        return boats;
    }

    public static void main(String[] args) {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        System.out.println(boatsToSavePeople.numRescueBoats(new int[] { 3, 2, 2, 1 }, 3));
        System.out.println(boatsToSavePeople.numRescueBoatsApproachTwo(new int[] { 3, 2, 2, 1 }, 3));
    }
}
