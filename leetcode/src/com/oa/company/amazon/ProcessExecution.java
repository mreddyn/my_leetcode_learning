package com.oa.company.amazon;

import java.util.*;

public class ProcessExecution {

    public static int totalExecutionTime(int[] execution) {
        // Step 1: Sort the execution times
        Arrays.sort(execution);

        int totalExecutionTime = 0;

        // Step 2: Process each execution time
        for (int i = 0; i < execution.length; i++) {
            int currentExecutionTime = execution[i];

            // Add the current execution time to the total execution time
            totalExecutionTime += currentExecutionTime;

            // Step 3: Reduce the execution times of subsequent cohesive processes
            for (int j = i + 1; j < execution.length && execution[j] == currentExecutionTime; j++) {
                execution[j] = (int) Math.ceil(execution[j] / 2.0);
            }
        }

        return totalExecutionTime;
    }

    public static void main(String[] args) {
        int[] execution1 = { 5, 5, 3, 6, 5, 3 };
        System.out.println(totalExecutionTime(execution1)); // Output: 21

        int[] execution2 = { 2, 2, 2, 2 };
        System.out.println(totalExecutionTime(execution2)); // Output: 8

        int[] execution3 = { 1, 1, 1, 1, 1 };
        System.out.println(totalExecutionTime(execution3)); // Output: 5
    }
}
