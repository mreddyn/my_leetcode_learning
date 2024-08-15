package com.oa.company.tiktok;

import java.util.List;

public class VideoProduction {

    public static int videoProduction(List<Integer> speed, int m) {
        int n = speed.size();

        long maxSpeed = 0;
        int maxIdx = 0;

        // Find the maximum speed and its index
        for (int ii = 0; ii < n; ii++) {
            if (speed.get(ii) > maxSpeed) {
                maxSpeed = speed.get(ii);
                maxIdx = ii;
            }
        }

        long low = 0, high = m * maxSpeed;
        int jobIdx = -1;

        // Binary search to find the minimum time to finish m jobs
        while (low <= high) {
            long t = low + (high - low) / 2;

            // Check if we can finish m jobs in time t
            long numJobs = 0;
            int latestJob = -1;
            long latestTime = -1;

            for (int ii = 0; ii < n; ii++) {
                numJobs += t / speed.get(ii) + ((t % speed.get(ii) == 0) ? 0 : 1);

                long endTime = (t / speed.get(ii)) * speed.get(ii) + ((t % speed.get(ii) == 0) ? 0 : 1) * speed.get(ii);
                if (endTime > latestTime) {
                    latestTime = endTime;
                    latestJob = ii;
                }
            }

            if (numJobs >= m) {
                jobIdx = latestJob;
                high = t - 1;
            } else {
                low = t + 1;
            }
        }

        return jobIdx + 1;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> speed = List.of(3, 2);
        int m = 3;
        System.out.println(videoProduction(speed, m)); // Example output
    }
}
