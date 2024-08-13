package com.oa.company.amazon;

public class SuitableWarehouseLocations {
    public int numberOfSuitableLocations(int[] center, int d) {
        int minLocation = Integer.MAX_VALUE, maxLocation = Integer.MIN_VALUE;
        int sum = 0;
        for (int c : center) {
            sum += c;
            minLocation = Math.min(minLocation, c);
            maxLocation = Math.max(maxLocation, c);
        }
        sum /= center.length;

        int left = minLocation - d, right = maxLocation + d;
        int minValid = lowerBound(center, d, left, sum);
        int maxValid = upperBound(center, d, sum, right);
        // System.out.println(minValid);
        // System.out.println(maxValid);
        if (minValid == -1 && maxValid == -1)
            return 0;
        return maxValid - minValid + 1;
    }

    public int lowerBound(int[] center, int d, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (isValid(center, d, mid)) {
                right = mid;
            } else
                left = mid;
        }

        if (isValid(center, d, left)) {
            return left;
        }
        if (isValid(center, d, right)) {
            return right;
        }

        return -1;
    }

    public int upperBound(int[] center, int d, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isValid(center, d, mid)) {
                left = mid;
            } else
                right = mid;
        }

        if (isValid(center, d, right)) {
            return right;
        }
        if (isValid(center, d, left)) {
            return left;
        }

        return -1;
    }

    public boolean isValid(int[] center, int d, int location) {
        int res = 0;
        for (int c : center) {
            res += 2 * Math.abs(location - c);
            if (res > d)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SuitableWarehouseLocations sLocations = new SuitableWarehouseLocations();
        System.out.println(sLocations.numberOfSuitableLocations(new int[] { 2, 0, 3, -4 }, 22));
    }
}
