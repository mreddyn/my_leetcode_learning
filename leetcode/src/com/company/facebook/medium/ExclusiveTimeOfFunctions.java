package com.company.facebook.medium;

import java.util.ArrayDeque;
import java.util.List;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        var stack = new ArrayDeque<Log>();
        var res = new int[n];
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                // if current log indicates this as start time then push ii to stack
                stack.push(log);
            } else {
                // else, this is means a function has ended.
                // pop the function's id and calculate the time spent
                Log top = stack.pop();
                res[top.id] += (log.time - top.time + 1);
                // if the stack is not empty then that means
                // the current function finished inside a previous function. so
                // remove the current function time from previous function time
                if (!stack.isEmpty()) {
                    res[stack.peek().id] -= (log.time - top.time + 1);
                }
            }
        }

        return res;
    }

    class Log {
        int id;
        boolean isStart;
        int time;

        Log(String content) {
            String[] strs = content.split(":");
            this.id = Integer.parseInt(strs[0]);
            this.isStart = (strs[1].equals("start"));
            this.time = Integer.parseInt(strs[2]);
        }
    }
}
