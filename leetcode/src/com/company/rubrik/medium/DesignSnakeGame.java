package com.company.rubrik.medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class DesignSnakeGame {
    Set<Integer> set;
    ArrayDeque<Integer> body;
    int[][] food;
    int foodIndex;
    int width;
    int height;
    int score;

    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.score = 0;
        set = new HashSet<>();
        set.add(0);
        body = new ArrayDeque<>();
        body.offerLast(0);
    }

    public int move(String direction) {
        if (score == -1) {
            // game over
            return -1;
        }

        int rowHead = body.peekFirst() / width;
        int colHead = body.peekFirst() % width;

        switch (direction) {
            case "U":
                rowHead--;
                break;
            case "D":
                rowHead++;
                break;
            case "L":
                colHead--;
                break;
            default:
                colHead++;
                break;
        }

        int head = rowHead * width + colHead;

        // case 1: out of boundary or eating body

        // new head can be in tail's position
        set.remove(body.peekLast());
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            score = -1;
            return score;
        }

        // add new head
        set.add(head);
        body.offerFirst(head);

        // case eating food and increment head
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(body.peekLast());
            foodIndex++;
            return ++score;
        }

        // case 3: normal move remove tail and add head
        body.pollLast();
        return score;
    }
}
