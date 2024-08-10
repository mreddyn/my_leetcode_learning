package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyCalender {
    List<int[]> calender;

    MyCalender() {
        calender = new ArrayList<>();
    }

    private boolean book(int start, int end) {
        if (!calender.isEmpty()) {
            Iterator<int[]> iterator = calender.iterator();
            while (iterator.hasNext()) {
                int[] curEvent = iterator.next();
                if (curEvent[0] >= end || start >= curEvent[1]) {
                    return false;
                }
            }
        }
        calender.add(new int[] { start, end });
        return true;
    }

    public static void main(String[] args) {
        MyCalender myCalender = new MyCalender();
        System.out.println(myCalender.book(10, 20));
        System.out.println(myCalender.book(15, 25));
        System.out.println(myCalender.book(20, 30));
    }
}
