package com.oa.company.chase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximizeCPU {
    public int maximizeCpu(List<Integer> requirements, int processingCapacity) {
        int maxUtilization = 0, n = requirements.size();
        Collections.sort(requirements);
        for (int i = 0; i < n; i++) {
            int currentCapacity = 0;
            for (int j = i; j < n; j++) {
                currentCapacity += requirements.get(j);
                if (currentCapacity >= processingCapacity) {
                    break;
                }
            }

            if (currentCapacity > processingCapacity) {
                continue;
            }
            maxUtilization = Math.max(currentCapacity, maxUtilization);

        }

        return maxUtilization;
    }

    public static void main(String[] args) {
        MaximizeCPU mCpu = new MaximizeCPU();
        System.out.println(mCpu.maximizeCpu(Arrays.asList(2, 9, 7), 15));
    }
}
