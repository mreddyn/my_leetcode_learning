package com.neetcode.roadmap.stack;

import java.util.Arrays;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleetCount = 0, n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            double timeTakenToTarget = (target - position[i]) / speed[i];
            cars[i][0] = position[i];
            cars[i][1] = timeTakenToTarget;
        }

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        double curTime = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cars[i][1] > curTime) {
                fleetCount++;
                curTime = cars[i][1];
            }
        }

        return fleetCount;
    }

    class Car {
        int position;
        double timeTakenToTarget;

        Car(int position, double timeTakenToTarget) {
            this.position = position;
            this.timeTakenToTarget = timeTakenToTarget;
        }
    }
}
