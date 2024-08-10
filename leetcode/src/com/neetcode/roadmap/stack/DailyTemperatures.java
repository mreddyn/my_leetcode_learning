package com.neetcode.roadmap.stack;

import java.util.ArrayDeque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        int[] answer = new int[days];
        ArrayDeque<CustomPair> stack = new ArrayDeque<>();
        /*
         * Maintain a stack which has temperature and temperature Index.
         * if the stack is empty then add current day temperature
         * else check if current day temperature is greater than temperature on top of
         * stack.
         * if it is then pop it and insert the days difference into the popped day
         * temperature
         */
        for (int i = 0; i < days; i++) {
            int currentTemperature = temperatures[i];
            int currentTemperatureIndex = i;
            while (!stack.isEmpty() && currentTemperature > stack.peek().temperature) {
                int colderTemperatureIndex = stack.pop().temperatureIndex;
                answer[colderTemperatureIndex] = currentTemperatureIndex - colderTemperatureIndex;
            }
            stack.push(new CustomPair(currentTemperature, currentTemperatureIndex));
        }
        return answer;
    }

    class CustomPair {
        int temperature;
        int temperatureIndex;

        CustomPair(int temperature, int temperatureIndex) {
            this.temperature = temperature;
            this.temperatureIndex = temperatureIndex;
        }
    }
}
