package com.oa.company.amazon;

import java.util.Arrays;

public class GroupTrainees {

    public static int groupStudents(int[] levels, int maxSpread) {
        // Sort the skill levels
        Arrays.sort(levels);

        int n = levels.length;
        int numClasses = 0;

        int i = 0;
        while (i < n) {
            numClasses++; // Start a new class
            int minLevel = levels[i];

            // Keep adding trainees to the current class as long as the spread condition is
            // met
            while (i < n && levels[i] - minLevel <= maxSpread) {
                i++;
            }
        }

        return numClasses;
    }

    public static void main(String[] args) {
        int[] levels = { 1, 4, 7, 3, 4 };
        int maxSpread = 2;
        System.out.println(groupStudents(levels, maxSpread)); // Output: 3
    }
}
