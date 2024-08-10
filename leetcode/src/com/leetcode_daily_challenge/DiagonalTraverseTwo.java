package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DiagonalTraverseTwo {
    private int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> diagonalOrderList = new ArrayList<>();
        int totalRows = nums.size();
        Queue<int[]> queue = new java.util.LinkedList<>();
        queue.add(new int[] { 0, 0 });
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];
                if (row < totalRows && col < nums.get(row).size()) {
                    diagonalOrderList.add(nums.get(row).get(col));
                }
                if (col == 0 && row + 1 < totalRows) {
                    queue.add(new int[] { row + 1, col });
                }
                if (col + 1 < nums.get(row).size()) {
                    queue.add(new int[] { row, col + 1 });
                }
            }

        }

        return diagonalOrderList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        DiagonalTraverseTwo diagonalTraverseTwo = new DiagonalTraverseTwo();
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        nums.add(row1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        nums.add(row2);
        List<Integer> row3 = new ArrayList<>();
        row3.add(7);
        row3.add(8);
        row3.add(9);
        nums.add(row3);
        int[] diagonalOrder = diagonalTraverseTwo.findDiagonalOrder(nums);
        for (int i = 0; i < diagonalOrder.length; i++) {
            System.out.print(diagonalOrder[i] + " ");
        }
    }
}
