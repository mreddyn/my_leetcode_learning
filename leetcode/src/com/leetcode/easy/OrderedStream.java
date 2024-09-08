package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    private String[] orderedStreamStorage;
    private int pointer;

    public OrderedStream(int n) {
        orderedStreamStorage = new String[n + 1];
        pointer = 1;
    }

    public List<String> insert(int idKey, String value) {
        orderedStreamStorage[idKey] = value;
        if (idKey != pointer) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        for (int index = idKey; index < orderedStreamStorage.length; index++) {
            String val = orderedStreamStorage[index];
            if (val == null) {
                pointer = index;
                break;
            } else {
                result.add(val);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        OrderedStream oStream = new OrderedStream(5);
        System.out.println(oStream.insert(3, "ccccc"));
        System.out.println(oStream.insert(1, "aaaaa"));
        System.out.println(oStream.insert(2, "bbbbb"));
        System.out.println(oStream.insert(5, "eeeee"));
        System.out.println(oStream.insert(4, "ddddd"));
    }
}
