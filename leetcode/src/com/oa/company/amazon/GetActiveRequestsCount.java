package com.oa.company.amazon;

import java.util.ArrayList;
import java.util.List;

public class GetActiveRequestsCount {
    public List<Integer> getActiveRequestsCount(int requests, int[] wait_time) {
        List<Integer> result = new ArrayList<>(requests);
        List<Integer> waitList = new ArrayList<>();
        for (int i = 0; i < wait_time.length; i++) {
            waitList.add(wait_time[i]);
        }

        int currentTime = 0;
        while (requests-- > 0) {
            // add the number of active requests for current time to result
            result.add(waitList.size());

            currentTime++;
            // serve the first request
            if (!waitList.isEmpty()) {
                waitList.remove(0);
            }

            // remove any requests that exceeded their wait time.
            for (int i = waitList.size() - 1; i >= 0; i--) {
                if ((waitList.get(i) - currentTime) <= 0) {
                    waitList.remove(i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GetActiveRequestsCount gCount = new GetActiveRequestsCount();
        System.out.println(gCount.getActiveRequestsCount(4, new int[] { 2, 2, 3, 1 }));
    }
}
