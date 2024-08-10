package com.leetcode;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class MovingAverageFromDataStream {
    class MovingAverage {
        int size;
        int count;
        Queue<Integer> queue;
        MovingAverage(int size){
            this.size = size;
            this.count = 0;
            queue = new ArrayDeque<>(size);
        }
        double next(int val) {
            queue.add(val);
            count++;
            while(count > size) {
                queue.poll();
                count--;
            }
            double movingAverage = 0;
            double sum = 0;
            Iterator<Integer> iterator = queue.iterator();
            while(iterator.hasNext()){
                sum += iterator.next();
            }
            movingAverage = sum/queue.size();
            return movingAverage;
        }
    }
}
