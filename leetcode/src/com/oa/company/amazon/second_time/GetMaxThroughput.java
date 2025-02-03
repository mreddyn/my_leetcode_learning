package com.oa.company.amazon.second_time;

import java.util.Arrays;

public class GetMaxThroughput {
    public long amazonGetMaxThroughput(int[] host_throughput) {
        // Sort the array of throughputs in ascending order
        Arrays.sort(host_throughput);

        long systemThroughput = 0;
        int n = host_throughput.length;
        // Number of clusters we can form is n / 3 (integer division)
        int numClusters = n / 3;

        // Each cluster of 3 picks the median from the second element of that triple
        // We start from the 'right' side of the sorted array:
        // The first median is at index (n - 2),
        // then next median is at index (n - 4), and so on ...

        // For i in [0..numClusters-1]:
        // medianIndex = n - 2 - 2*i
        // systemThroughput += host_throughput[medianIndex]

        for (int i = 0; i < numClusters; i++) {
            int medianIndex = n - 2 - 2 * i;
            systemThroughput += host_throughput[medianIndex];
        }

        return systemThroughput;
    }

    public static void main(String[] args) {
        GetMaxThroughput obj = new GetMaxThroughput();
        System.out.println(obj.amazonGetMaxThroughput(new int[] { 4, 6, 3, 5, 4, 5 }));
    }
}
