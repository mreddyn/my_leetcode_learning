package com.oa.company.tiktok;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LoadBalancer {

    public int[] getServerIndex(int n, int[] arrival, int[] burstTime) {
        int m = arrival.length;
        int[] serverAvailability = new int[n]; // Array to track when each server will be free
        int[] result = new int[m]; // Result array to store server indices for each request

        Arrays.fill(serverAvailability, 0); // Initialize all servers as available at time 0

        for (int i = 0; i < m; i++) {
            int requestTime = arrival[i];
            int burst = burstTime[i];
            int assignedServer = -1;

            // Find the first available server
            for (int j = 0; j < n; j++) {
                if (serverAvailability[j] <= requestTime) {
                    assignedServer = j + 1; // Server index is 1-based
                    break;
                }
            }

            // If a server is found, assign the request
            if (assignedServer != -1) {
                result[i] = assignedServer;
                serverAvailability[assignedServer - 1] = requestTime + burst; // Update the availability time
            } else {
                result[i] = -1; // No server is available, request is dropped
            }
        }

        return result;
    }

    static void printLoadOnEachServer(int m, int[] loadOnServer) {

        // Traverse the loadOnServer and
        // print each loads
        for (int i = 0; i < m; i++) {
            System.out.println((i + 1) + "st Server -> " + loadOnServer[i] + ".");
        }
    }

    static void loadBalancing(int n, int m, int[] arrivalTime, int[] processTime) {

        // Stores the load on each Server
        int[] loadOnServer = new int[m];

        // Minimum priority queue for
        // storing busy servers according
        // to their release time
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        // Set to store available Servers
        TreeSet<Integer> availableServers = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            // Initially, all servers are free
            availableServers.add(i);
        }

        // Iterating through the requests.
        for (int i = 0; i < n; i++) {
            // End time of current request
            // is the sum of arrival time
            // and process time
            int endTime = arrivalTime[i] + processTime[i];

            // Releasing all the servers which
            // have become free by this time
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= arrivalTime[i]) {
                // Pop the server
                int[] releasedServer = busyServers.poll();
                // Insert available server
                availableServers.add(releasedServer[1]);
            }

            // If there is no free server,
            // the request is dropped
            if (availableServers.isEmpty()) {
                continue;
            }

            int demandedServer = i % m;

            // Searching for demanded server
            Integer assignedServer = availableServers.ceiling(demandedServer);
            if (assignedServer == null) {
                // If demanded Server is not free
                // and no server is free after it,
                // then choose first free server
                assignedServer = availableServers.first();
            }

            // Increasing load on assigned Server
            loadOnServer[assignedServer]++;

            // Removing assigned server from list
            // of assigned servers
            availableServers.remove(assignedServer);

            // Add assigned server in the list of
            // busy servers with its release time
            busyServers.offer(new int[] { endTime, assignedServer });
        }

        // Function to print load on
        printLoadOnEachServer(m, loadOnServer);
    }

    public static void main(String[] args) {
        LoadBalancer lb = new LoadBalancer();

        int n = 3;
        int[] arrival = { 2, 4, 1, 8, 9 };
        int[] burstTime = { 7, 9, 2, 4, 5 };

        int[] result = lb.getServerIndex(n, arrival, burstTime);
        System.out.println(Arrays.toString(result)); // Output: [1, 2, 1, 3, 2]

        loadBalancing(5, 3, arrival, burstTime);
    }
}
