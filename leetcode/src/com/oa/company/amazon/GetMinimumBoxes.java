package com.oa.company.amazon;

import java.util.Arrays;

public class GetMinimumBoxes {
    public int getMinimumBoxes(int[] boxes, int capacity) {
        Arrays.sort(boxes);
        int total = 0;
        int slow = 0;
        for (int fast = 0; fast < boxes.length; fast++) {
            while (boxes[fast] > boxes[slow] * capacity) {
                slow++;
            }
            total = Math.max(total, fast - slow + 1);

        }
        return boxes.length - total;
    }

    public static void main(String[] args) {
        GetMinimumBoxes gBoxes = new GetMinimumBoxes();
        System.out.println(gBoxes.getMinimumBoxes(new int[] { 1, 4, 3, 2 }, 2));
    }
}
