package com.oa.company.chase;

import java.util.ArrayList;
import java.util.List;

public class QuestionThree {
    public void smallestLocalPeak(int[] arr) {
        List<Integer> list = new ArrayList<>();
        List<Integer> peakList = new ArrayList<>();
        list.add(0);
        for (int i : arr) {
            list.add(i);
        }
        list.add(0);

        while (list.size() > 2) {
            int peakElement = Integer.MAX_VALUE;
            int peakElementIndex = 0;
            for (int index = 1; index < list.size() - 1; index++) {
                if (list.get(index) > list.get(index - 1) && list.get(index) > list.get(index + 1)) {
                    if (list.get(index) < peakElement) {
                        peakElement = list.get(index);
                        peakElementIndex = index;
                    }
                }
            }
            peakList.add(peakElement);
            list.remove(peakElementIndex);
            
        }
        System.out.println(peakList);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 4, 2 };
        new QuestionThree().smallestLocalPeak(arr);
    }
}
