package com.company.microsoft;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("welcome manikanta");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        // Iterator<Integer> it = stack.descendingIterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }
        stack.add(7);
        stack.add(8);
        stack.add(9);
        stack.add(10);
        stack.add(11);
        stack.add(12);
        System.out.println(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
