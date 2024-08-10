package com.oa.company.IBM;

import java.util.Arrays;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    private int[] getTotalExecutionTime(int n, String[] logs) {
        int[] exclusiveTimes = new int[n];
        Stack<Integer> stack = new Stack<>();
        int previousTimestamp = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String action = parts[1];
            int timestamp = Integer.parseInt(parts[2]);
            if (action.equals("start")) {
                if (!stack.isEmpty()) {
                    exclusiveTimes[stack.peek()] += timestamp - previousTimestamp;
                }
                stack.push(functionId);
                previousTimestamp = timestamp;
            } else {
                int startFunctionId = stack.pop();
                exclusiveTimes[startFunctionId] += timestamp - previousTimestamp + 1;
                previousTimestamp = timestamp + 1;
            }
        }

        return exclusiveTimes;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] logs = { "0:start:0", "1:start:3", "1:end:6", "2:start:8", "2:end:10", "0:end:12" };
        ExclusiveTimeOfFunctions exclusiveTimeOfFunctions = new ExclusiveTimeOfFunctions();
        int[] result = exclusiveTimeOfFunctions.getTotalExecutionTime(n, logs);
        System.out.println(Arrays.toString(result));
    }
}
