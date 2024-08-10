package com.company.amazon.leetcode;

public class FinalValueAfterPerformingOperations {
    private int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.equals("--X") || operation.equals("X--")) {
                x--;
            } else if (operation.equals("++X") || operation.equals("X++")) {
                x++;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        String[] operations = { "--X" };
        FinalValueAfterPerformingOperations finalValueAfterPerformingOperations = new FinalValueAfterPerformingOperations();
        finalValueAfterPerformingOperations.finalValueAfterOperations(operations);
    }
}
