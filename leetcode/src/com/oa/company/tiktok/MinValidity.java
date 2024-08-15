package com.oa.company.tiktok;

import java.util.*;

public class MinValidity {

    public static int minValidityBinarySearch(List<Integer> arr) {
        int n = arr.size();
        Collections.sort(arr);

        int minValidity = Integer.MAX_VALUE;
        for (int ii = 0; ii < n; ++ii) {
            for (int jj = ii + 1; jj < n; ++jj) {
                int delta = arr.get(jj) - arr.get(ii);

                // Find arr[jj] + delta
                int kk = bsearch(arr, arr.get(jj) + delta, jj + 1);

                minValidity = Math.min(minValidity, validity(arr, ii, jj, kk));
                minValidity = Math.min(minValidity, validity(arr, ii, jj, kk + 1));
            }
        }
        return minValidity;
    }

    // Binary search function to find the closest value to x starting from index l
    private static int bsearch(List<Integer> arr, int x, int l) {
        int lo = l;
        int hi = arr.size() - 1;
        int start = lo;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) == x) {
                return mid;
            } else if (arr.get(mid) < x) {
                start = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return start;
    }

    // Function to calculate the validity for indices ii, jj, and kk
    private static int validity(List<Integer> arr, int ii, int jj, int kk) {
        if (kk >= arr.size())
            return Integer.MAX_VALUE;
        return Math.abs(arr.get(ii) + arr.get(jj) + arr.get(kk) - 3 * arr.get(jj));
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(20, 15, 99, 100);
        int result = minValidityBinarySearch(arr);
        System.out.println("Minimum Validity: " + result);
    }
}
