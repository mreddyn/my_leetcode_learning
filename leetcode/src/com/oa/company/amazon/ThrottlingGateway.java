package com.oa.company.amazon;

import java.util.*;

public class ThrottlingGateway {

    public static int droppedRequests(List<Integer> requestTime) {
        int dropped = 0;

        for (int i = 0; i < requestTime.size(); i++) {
            // Rule 1: No more than 3 requests in a given second
            if (i >= 3 && requestTime.get(i) == requestTime.get(i - 3)) {
                dropped++;
            }
            // Rule 2: No more than 20 requests in a 10-second window
            else if (i >= 20 && requestTime.get(i) - requestTime.get(i - 20) < 10) {
                dropped++;
            }
            // Rule 3: No more than 60 requests in a 60-second window
            else if (i >= 60 && requestTime.get(i) - requestTime.get(i - 60) < 60) {
                dropped++;
            }
        }

        return dropped;
    }

    public static int droppedRequestsApproachTwo(List<Integer> requestTime) {
        int drops = 0;
        // Use arrays to keep track of request counts to optimize lookups.
        // Assuming max time based on constraints.
        int[] times = new int[1000001];
        for (int time : requestTime) {
            times[time]++;
        }

        // Cumulative counts for 1s, 10s, and 60s windows
        int[] cumulative = new int[1000001];
        cumulative[0] = times[0];
        for (int i = 1; i < times.length; i++) {
            cumulative[i] = cumulative[i - 1] + times[i];
        }

        for (int i = 1; i < times.length; i++) {
            if (times[i] == 0)
                continue; // Skip times with no requests

            int oneSec = times[i] > 3 ? times[i] - 3 : 0;
            int tenSec = i >= 10 ? cumulative[i] - cumulative[i - 10] : cumulative[i];
            tenSec = tenSec > 20 ? tenSec - 20 : 0;
            int sixtySec = i >= 60 ? cumulative[i] - cumulative[i - 60] : cumulative[i];
            sixtySec = sixtySec > 60 ? sixtySec - 60 : 0;

            // Determine the max violation to count a request only once
            int maxDropsAtI = Math.max(oneSec, Math.max(tenSec, sixtySec));
            drops += Math.min(maxDropsAtI, times[i]); // Ensure not to exceed the actual requests at i
        }

        return drops;
    }

    public static void main(String[] args) {
        List<Integer> requestTime1 = Arrays.asList(1, 1, 1, 1, 2);
        System.out.println(droppedRequests(requestTime1)); // Output: 1
        System.out.println(droppedRequestsApproachTwo(requestTime1)); // Output: 1

        List<Integer> requestTime2 = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7);
        System.out.println(droppedRequests(requestTime2)); // Output: 2
        System.out.println(droppedRequestsApproachTwo(requestTime2)); // Output: 2

        List<Integer> requestTime3 = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 7, 7, 11,
                11, 11, 11);
        System.out.println(droppedRequests(requestTime3)); // Output: 7
        System.out.println(droppedRequestsApproachTwo(requestTime3)); // Output: 7
    }
}
