package com.oa.company.tiktok;

import java.util.HashMap;
import java.util.Map;

public class ExchangeCups {
    public static int exchangeCups(int[] labels) {
        // Create a map to keep track of the current indices of each value
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < labels.length; i++) {
            numMap.put(labels[i], i);
        }

        int N = labels.length;
        int count = 0;

        // Iterate through the labels array
        for (int i = 1; i < N; i++) {
            if (numMap.get(i) == i - 1) {
                continue;
            } else {
                // Get the index of the element that should be at position i-1
                int index = numMap.get(i);
                // Swap the elements
                int temp = labels[i - 1];
                labels[i - 1] = labels[index];
                labels[index] = temp;

                // Update the map with new indices
                numMap.put(labels[i - 1], i - 1);
                numMap.put(labels[index], index);

                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] labels = { 3, 1, 2, 5, 4 };
        System.out.println(exchangeCups(labels)); // Output the result
    }
}
