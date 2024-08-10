package com.oa.company.chase;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class QuestionTwo {
    public int sumAndCost(List<Integer> num) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(num);
        int sum = priorityQueue.poll();
        int cost = 0;
        while (!priorityQueue.isEmpty()) {
            int currentElement = priorityQueue.poll();
            if (currentElement < sum) {
                priorityQueue.add(sum);
                sum = currentElement;
            } else {
                sum += currentElement;
                cost += sum;
                continue;
            }

            sum += priorityQueue.poll();
            cost += sum;
        }

        return cost;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,6,8);
        int res = new QuestionTwo().sumAndCost(list);
        System.out.println(res);
    }
}
