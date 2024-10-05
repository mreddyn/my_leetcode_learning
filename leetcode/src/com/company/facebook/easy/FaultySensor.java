package com.company.facebook.easy;

public class FaultySensor {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int n = sensor1.length;

        for (int i = 0; i < n - 1; i++) {
            if (sensor1[i] != sensor2[i]) {
                // when the readings from sensors are different
                if (sensor1[i] == sensor2[i + 1] && sensor2[i] != sensor1[i + 1]) {
                    // if only first sensor values are shifted by one (of second sensor values)
                    return 1;
                } else if (sensor2[i] == sensor1[i + 1] && sensor1[i] != sensor2[i + 1]) {
                    // if only second sensor values are shifted by one (of first sensor values)
                    return 2;
                }
            }
        }
        // both sensors are ambiguous, so return -1
        return -1;
    }
}
