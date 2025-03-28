package com.company.doordash;

import java.util.ArrayDeque;
import java.util.Deque;

public class StreamMaximumValueTime {

    private int window;
    private Deque<Pair> deque;

    class Pair {
        int timestamp;
        int value;

        Pair(int timestamp, int value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public StreamMaximumValueTime(int window) {
        this.window = window;
        this.deque = new ArrayDeque<>();
    }

    private void setValue(int timestamp, int value) {
        // remove all values that are less than the current value
        while (!deque.isEmpty() && deque.peekLast().value < value) {
            deque.pollLast();
        }
        deque.offerLast(new Pair(timestamp, value));
    }

    // Return the maximum value in the stream within the last 'window' seconds.
    private int getMaxValue(int currentTime) {
        // remove all values that are out of the window
        while (!deque.isEmpty() && deque.peekFirst().timestamp <= currentTime - window) {
            deque.pollFirst();
        }

        if (deque.isEmpty()) {
            return -1;
        }

        return deque.peekFirst().value;
    }

    public static void main(String[] args) {
        StreamMaximumValueTime streamMaximumValueTime = new StreamMaximumValueTime(3);
        streamMaximumValueTime.setValue(1, 1);
        streamMaximumValueTime.setValue(2, 2);
        streamMaximumValueTime.setValue(3, 3);
        streamMaximumValueTime.setValue(4, 2);
        streamMaximumValueTime.setValue(5, 1);
        streamMaximumValueTime.setValue(6, 4);
        streamMaximumValueTime.setValue(7, 5);
        streamMaximumValueTime.setValue(8, 6);
        streamMaximumValueTime.setValue(9, 7);
        streamMaximumValueTime.setValue(10, 8);
        System.out.println(streamMaximumValueTime.getMaxValue(10)); // 8
        System.out.println(streamMaximumValueTime.getMaxValue(9)); // 7
        System.out.println(streamMaximumValueTime.getMaxValue(8)); // 6
        System.out.println(streamMaximumValueTime.getMaxValue(7)); // 5
        System.out.println(streamMaximumValueTime.getMaxValue(6)); // 4
        System.out.println(streamMaximumValueTime.getMaxValue(5)); // 4
        System.out.println(streamMaximumValueTime.getMaxValue(4)); // 3
        System.out.println(streamMaximumValueTime.getMaxValue(3)); // 3
        System.out.println(streamMaximumValueTime.getMaxValue(2)); // 2
        System.out.println(streamMaximumValueTime.getMaxValue(1)); // 1
    }
}
