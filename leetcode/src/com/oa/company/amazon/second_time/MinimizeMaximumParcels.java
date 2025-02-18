package com.oa.company.amazon.second_time;

public class MinimizeMaximumParcels {
    public int minimizeMaximumParcels(int[] parcels, int extraParcels) {
        int sum = extraParcels, max = Integer.MIN_VALUE;
        for (int p : parcels) {
            sum += p;
            max = Math.max(max, p);
        }

        int average = (int) Math.ceil((double) sum / parcels.length);
        return max > average ? max : average;
    }

    public static void main(String[] args) {
        MinimizeMaximumParcels obj = new MinimizeMaximumParcels();
        System.out.println(obj.minimizeMaximumParcels(new int[] { 7, 5, 1, 9, 1 }, 25));
        System.out.println(obj.minimizeMaximumParcels(new int[] { 1, 2, 3 }, 3));
        System.out.println(obj.minimizeMaximumParcels(new int[] { 1 }, 3));
    }
}
