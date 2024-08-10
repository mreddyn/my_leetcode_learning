package com.leetcode_daily_challenge;

import java.util.PriorityQueue;

public class PaintingTheWalls {
    private int paintWalls(int[] cost, int[] time) {
        if (cost.length == 1) {
            return cost[0];
        }
        int totalPaintCost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        for (int index = 0; index < cost.length; index++) {
            pq.add(new int[] { cost[index], time[index] });
        }
        int index = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            cost[index] = temp[0];
            time[index] = temp[1];
            index++;
        }
        for (int i = 0; i < cost.length; i++) {
            System.out.println(cost[i] + " " + time[i]);
        }
        int paidPainterWallIndex = 0;
        int freePainterWallIndex = cost.length - 1;
        while (cost[paidPainterWallIndex] != 0 && paidPainterWallIndex < freePainterWallIndex) {
            if (time[paidPainterWallIndex] == 1) {
                totalPaintCost += cost[paidPainterWallIndex];
                paidPainterWallIndex++;
                cost[freePainterWallIndex] = 0;
                time[freePainterWallIndex] = 0;
                freePainterWallIndex--;
            } else {
                totalPaintCost += cost[paidPainterWallIndex];
                int numberOfFreePainterWalls = time[paidPainterWallIndex];
                while (freePainterWallIndex > paidPainterWallIndex && numberOfFreePainterWalls-- > 0) {
                    cost[freePainterWallIndex] = 0;
                    time[freePainterWallIndex] = 0;
                    freePainterWallIndex--;
                }
                paidPainterWallIndex++;
            }
        }

        if (paidPainterWallIndex == freePainterWallIndex && cost[paidPainterWallIndex] != 0) {
            totalPaintCost += cost[paidPainterWallIndex];
        }
        return totalPaintCost;
    }

    public static void main(String[] args) {
        PaintingTheWalls paintingTheWalls = new PaintingTheWalls();
        int[] cost = { 26, 53, 10, 24, 25, 20, 63, 51 };
        int[] time = { 1, 1, 1, 1, 2, 2, 2, 1 };
        System.out.println(paintingTheWalls.paintWalls(cost, time));
    }
}
