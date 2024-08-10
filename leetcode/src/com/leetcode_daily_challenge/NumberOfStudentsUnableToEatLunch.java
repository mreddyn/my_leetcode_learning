package com.leetcode_daily_challenge;

public class NumberOfStudentsUnableToEatLunch {
    private int countStudents(int[] students, int[] sandwiches) {
        int totalStudents = students.length, totalSandwiches = sandwiches.length, sandwichPointer = 0;
        for (int i = 0; i < totalSandwiches; i++) {
            int sandwich = sandwiches[i];
            boolean isDifferent = false;
            for (int j = 0; j < totalStudents; j++) {
                int student = students[j];
                if (student == -1) {
                    continue;
                }
                if (sandwich == student) {
                    students[j] = -1;
                    isDifferent = true;
                    sandwichPointer++;
                    break;
                }
            }
            if (!isDifferent) {
                break;
            }
        }
        for (int i = 0; i < totalStudents; i++) {
            System.out.print(students[i] + " ");
        }
        System.out.println();
        return totalStudents - sandwichPointer;
    }

    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch numberOfStudentsUnableToEatLunch = new NumberOfStudentsUnableToEatLunch();
        System.out.println(numberOfStudentsUnableToEatLunch.countStudents(new int[] { 1, 1, 1, 0, 0,
                1 }, new int[] { 1, 0, 0, 0, 1, 1 }));
    }
}
