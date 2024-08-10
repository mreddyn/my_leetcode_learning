package com.leetcode_daily_challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfTwoArrays {
    private int[] intersection(int[] nums1, int[] nums2) {
        int n,m;
        n = nums1.length;
        m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        int firstArrayPointer, secondArrayPointer;
        firstArrayPointer = 0;
        secondArrayPointer = 0;
        while( firstArrayPointer < n && secondArrayPointer < m) {
            if(nums1[firstArrayPointer] == nums2[secondArrayPointer]) {
                set.add(nums1[firstArrayPointer]);
                firstArrayPointer++;
                secondArrayPointer++;
            } else if(nums1[firstArrayPointer] > nums2[secondArrayPointer]) {
                secondArrayPointer++;
            } else {
                firstArrayPointer++;
            }
        }
        int size = set.size();
        int[] res = new int[size];
        int index = 0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            res[index++] = iterator.next(); 
        }
        return res;
    }
}
