package com.oa.company.IBM;

import java.util.Arrays;

public class CirclesRelationship {
    private String[] circles(int n, String[] circlePairs) {
        String[] result = new String[n];
        int index = 0;
        for (String pair : circlePairs) {
            String[] descriptors = pair.split(" ");
            int x1 = Integer.parseInt(descriptors[0]);
            int y1 = Integer.parseInt(descriptors[1]);
            int r1 = Integer.parseInt(descriptors[2]);
            int x2 = Integer.parseInt(descriptors[3]);
            int y2 = Integer.parseInt(descriptors[4]);
            int r2 = Integer.parseInt(descriptors[5]);
            int distance = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            if (distance > (r1 + r2)) {
                result[index] = "Disjoint-Outside";
            } else if (distance == (r1 + r2)) {
                result[index] = "Touching";
            } else if (x1 == x2 && y1 == y2) {
                result[index] = "Concentric";
            } else if ((r1 + r2) > distance && distance > Math.abs(r1 - r2)) {
                result[index] = "Intersecting";
            } else if (distance + r1 > r2 || distance + r2 > r1) {
                result[index] = "Disjoint-Inside";
            }
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        CirclesRelationship circlesRelationship = new CirclesRelationship();
        String[] result = circlesRelationship.circles(2, new String[] { "3 0 10 5 0 3", "0 1 4 0 1 5" });
        System.out.println(Arrays.toString(result));
    }
}
