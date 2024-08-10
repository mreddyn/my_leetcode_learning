package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSortString {
    private int[] orderPriority;

    private String customSortString(String order, String s) {
        int orderSize, sSize;
        orderSize = order.length();
        sSize = s.length();
        orderPriority = new int[26];
        int priorityValue = 1;
        for (int index = 0; index < orderSize; index++) {
            char c = order.charAt(index);
            orderPriority[c - 'a'] = priorityValue++;
        }
        List<Character> list = new ArrayList<>(sSize);
        for (int index = 0; index < sSize; index++) {
            list.add(s.charAt(index));
        }
        System.out.println(list);
        Collections.sort(list, new CustomComparator());
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < sSize; index++) {
            sb.append(list.get(index));
        }
        return sb.toString();
    }

    public class CustomComparator implements Comparator<Character> {

        @Override
        public int compare(Character firstChar, Character secondChar) {
            int firstCharPriority = orderPriority[firstChar - 'a'];
            int secondCharPriority = orderPriority[secondChar - 'a'];
            if (firstCharPriority == secondCharPriority) {
                return 0;
            } else if (firstCharPriority > secondCharPriority) {
                return 1;
            } else {
                return -1;
            }
        }

    }

    public static void main(String[] args) {
        CustomSortString customSortString = new CustomSortString();
        System.out.println(customSortString.customSortString("cba", "abcd"));
        System.out.println(customSortString.customSortString("bcafg", "abcd"));
    }
}
