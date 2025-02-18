package com.oa.company.amazon.second_time;

import java.util.Arrays;

public class WarehouseAllocation {
    public long findMinimumOperations(int[] boxes) {
        Arrays.sort(boxes);
        int n = boxes.length;
        int operations = 0;

        int left = 0, right = n - 1;

        while (boxes[right] - boxes[left] > 1) {
            boxes[right]--;
            boxes[left]++;
            operations++;

            if (boxes[left] > boxes[left + 1]) {
                left++;
            }
            if (boxes[right] < boxes[right - 1]) {
                right--;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        WarehouseAllocation obj = new WarehouseAllocation();
        System.out.println(obj.findMinimumOperations(new int[] { 5, 5, 8, 7 }));
        System.out.println(obj.findMinimumOperations(new int[] { 2, 4, 1 }));
        System.out.println(obj.findMinimumOperations(new int[] { 4, 4, 4, 4, 4 }));
    }
}
