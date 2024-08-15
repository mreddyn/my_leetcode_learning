package com.oa.company.amazon;

import java.util.Arrays;

public class Srujan {

    public static int calculateDist(int mid, int[] centers) {
        int dist = 0;
        for (int center : centers) {
            dist += Math.abs(mid - center);
        }
        return 2 * dist;
    }

    public static Integer leftBoundary(int found, int[] centers, int d) {
        int i = Arrays.stream(centers).min().orElse(0) - d;
        int j = found;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int dist = calculateDist(mid, centers);

            if (dist <= d) {
                if (calculateDist(mid - 1, centers) > d) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            } else {
                i = mid + 1;
            }
        }
        return null;
    }

    public static Integer rightBoundary(int found, int[] centers, int d) {
        int i = found;
        int j = Arrays.stream(centers).max().orElse(0) + d;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int dist = calculateDist(mid, centers);

            if (dist <= d) {
                if (calculateDist(mid + 1, centers) > d) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            } else {
                j = mid - 1;
            }
        }
        return null;
    }

    public static int suitableLocation(int[] centers, int d) {
        int i = Arrays.stream(centers).min().orElse(0) - d;
        int j = Arrays.stream(centers).max().orElse(0) + d;
        Integer found = null;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            int leftDist = calculateDist(i, centers);
            int rightDist = calculateDist(j, centers);

            if (leftDist <= d) {
                found = i;
            }
            if (rightDist <= d) {
                found = j;
            }

            if (leftDist > rightDist) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        if (found == null) {
            return 0;
        }

        Integer lB = leftBoundary(found, centers, d);
        Integer rB = rightBoundary(found, centers, d);

        return (rB != null && lB != null) ? (rB - lB + 1) : 0;
    }

    public static void main(String[] args) {
        int[] centers1 = { 2, 0, 3, -4 };
        int d1 = 22;
        System.out.println(suitableLocation(centers1, d1));

        int[] centers2 = { -3, 2, 2 };
        int d2 = 8;
        System.out.println(suitableLocation(centers2, d2));
    }
}
