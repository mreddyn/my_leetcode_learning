package com.oa.company.amazon;

public class LoadBalancer {

    public static int[] getServerIds(int num_servers, int[] requests) {
        int[] serverLoads = new int[num_servers];
        int[] result = new int[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int minLoad = Integer.MAX_VALUE;
            int serverId = -1;

            for (int j = 0; j <= requests[i]; j++) {
                if (serverLoads[j] < minLoad) {
                    minLoad = serverLoads[j];
                    serverId = j;
                }
            }

            // Assign the request to the found server
            result[i] = serverId;
            serverLoads[serverId]++;
        }

        return result;
    }

    public static void main(String[] args) {
        int num_servers1 = 5;
        int[] requests1 = { 4, 0, 2, 2 };
        int[] result1 = getServerIds(num_servers1, requests1);
        // Output: [0, 0, 1, 1]
        for (int res : result1) {
            System.out.print(res + " ");
        }
        System.out.println();

        int num_servers2 = 5;
        int[] requests2 = { 0, 1, 2, 3 };
        int[] result2 = getServerIds(num_servers2, requests2);
        // Output: [0, 0, 1, 2]
        for (int res : result2) {
            System.out.print(res + " ");
        }
        System.out.println();

        int num_servers3 = 5;
        int[] requests3 = { 3, 2, 3, 2, 4 };
        int[] result3 = getServerIds(num_servers3, requests3);
        // Output: [0, 1, 2, 0, 3]
        for (int res : result3) {
            System.out.print(res + " ");
        }
        System.out.println();
    }
}
