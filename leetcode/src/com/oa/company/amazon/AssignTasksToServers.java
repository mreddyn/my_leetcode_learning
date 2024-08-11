package com.oa.company.amazon;

import java.util.ArrayList;
import java.util.List;

public class AssignTasksToServers {
    public List<Integer> assignTasks(int servers, int[] requests) {
        int[] serverLoad = new int[servers];
        List<Integer> result = new ArrayList<>();

        int n = requests.length;
        // iterate through each request
        for (int i = 0; i < n; i++) {
            int maxServerIndex = requests[i];
            int selectedServer = -1;
            int minLoad = Integer.MAX_VALUE;
            // check servers 0 to until maxServerIndex
            for (int j = 0; j <= maxServerIndex; j++) {
                if (serverLoad[j] < minLoad) {
                    minLoad = serverLoad[j];
                    selectedServer = j;
                }
            }

            // assign the request to least busy server
            result.add(selectedServer);
            serverLoad[selectedServer]++;
        }

        return result;
    }

    public static void main(String[] args) {
        AssignTasksToServers aServers = new AssignTasksToServers();
        System.out.println(aServers.assignTasks(5, new int[] { 3, 2, 3, 2, 4 }));
    }
}
