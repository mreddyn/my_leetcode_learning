package com.oa.company.amazon.second_time;

import java.util.Arrays;
import java.util.Collections;

public class MaximizeTotalMemoryPoints {
    public long maximizeTotalMemoryPoints(int[] memory) {
        Integer[] memArr = Arrays.stream(memory).boxed().toArray(Integer[]::new);
        Arrays.sort(memArr, Collections.reverseOrder());

        long maxMemoryPoints = 0;
        long prefixSum = 0;

        for (int i = 0; i < memArr.length; i++) {
            prefixSum += memArr[i];
            maxMemoryPoints += prefixSum;
        }

        return maxMemoryPoints;
    }

    public static void main(String[] args) {
        MaximizeTotalMemoryPoints obj = new MaximizeTotalMemoryPoints();
        System.out.println(obj.maximizeTotalMemoryPoints(new int[] { 3, 4, 5 }));
        System.out.println(obj.maximizeTotalMemoryPoints(new int[] { 4, 5, 6 }));
        System.out.println(obj.maximizeTotalMemoryPoints(new int[] { 7, 8, 9 }));
    }
}
