package com.company.servicenow;

import java.util.Stack;

public class DailyTemperatures {
    private int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] warmerTemperatures = new int[n];
        Stack<CustomPair> stack = new Stack<>();
        for (int currentDay = 0; currentDay < n; currentDay++) {
            int currentTemperature = temperatures[currentDay];
            while(!stack.isEmpty() && currentTemperature > stack.peek().temperature){
                CustomPair pair = stack.pop();
                int lowerTemperatureIndex = pair.temperatureIndex;
                warmerTemperatures[lowerTemperatureIndex] = currentDay - lowerTemperatureIndex;
            }
            stack.add(new CustomPair(currentTemperature, currentDay));
        }

        return warmerTemperatures;
    }

    class CustomPair {
        int temperature;
        int temperatureIndex;

        CustomPair() {
        }

        CustomPair(int temperature, int temperatureIndex) {
            this.temperature = temperature;
            this.temperatureIndex = temperatureIndex;
        }
    }
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(dailyTemperatures.dailyTemperatures(new int[]{}));
    }
}
