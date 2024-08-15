package com.oa.company.amazon;

import java.util.ArrayList;

public class srujan2 {

    public static long getTotalDist(long mid, ArrayList<Long> center) {
        long total = 0;
        for (Long pos : center) {
            total += 2 * Math.abs(pos - mid);
        }
        return total;
    }

    public static long suitableLocation(ArrayList<Long> center, long d) {
        long lo = -1_000_000_000L, hi = 1_000_000_000L;
        boolean found = false;
        long first = -1;

        // First binary search to find the smallest suitable position
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long dist = getTotalDist(mid, center);
            long dist1 = getTotalDist(mid + 1, center);

            if (dist <= d) {
                found = true;
                first = mid;
                hi = mid - 1;
            } else if (dist < dist1) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (!found)
            return 0;

        lo = first;
        hi = 1_000_000_000L;
        long last = -1;

        // Second binary search to find the largest suitable position
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long dist = getTotalDist(mid, center);
            long dist1 = getTotalDist(mid + 1, center);

            if (dist <= d) {
                last = mid;
                lo = mid + 1;
            } else if (dist < dist1) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return last - first + 1;
    }

    public static void main(String[] args) {
        ArrayList<Long> centers = new ArrayList<>();
        centers.add(2L);
        centers.add(0L);
        centers.add(3L);
        centers.add(-4L);
        long d = 22;

        System.out.println(suitableLocation(centers, d));

        ArrayList<Long> centers2 = new ArrayList<>();
        centers2.add(-3L);
        centers2.add(2L);
        centers2.add(2L);
        long d2 = 8;

        System.out.println(suitableLocation(centers2, d2));
    }
}
