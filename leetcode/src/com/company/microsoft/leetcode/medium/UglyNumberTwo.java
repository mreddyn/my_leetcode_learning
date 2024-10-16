package com.company.microsoft.leetcode.medium;

import java.util.TreeSet;

public class UglyNumberTwo {
    public int nthUglyNumber(int n) {
        int lastUglyNumber = 1, uglyNumberCount = 0, number = 0;
        while (uglyNumberCount < n) {
            int num = ++number;
            while (num % 2 == 0) {
                num = num / 2;
            }

            while (num % 3 == 0) {
                num = num / 3;
            }

            while (num % 5 == 0) {
                num = num / 5;
            }

            if (num == 1) {
                uglyNumberCount++;
                lastUglyNumber = number;
            }
        }

        return lastUglyNumber;
    }

    public int nthUglyNumberApproachTwo(int n) {
        // TreeSet store unique elements and sorts them in ascending order
        var uglyNumberSet = new TreeSet<Long>();

        uglyNumberSet.add(1L);
        Long currentUgly = 1L;
        for (int i = 0; i < n; i++) {
            // get the smallest number from the set
            currentUgly = uglyNumberSet.pollFirst();

            // add the ugly numbers into the set
            uglyNumberSet.add(currentUgly * 2);
            uglyNumberSet.add(currentUgly * 3);
            uglyNumberSet.add(currentUgly * 5);
        }
        return currentUgly.intValue();
    }
}
