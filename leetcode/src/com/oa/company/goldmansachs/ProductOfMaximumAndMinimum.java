package com.oa.company.goldmansachs;

import java.util.TreeMap;

public class ProductOfMaximumAndMinimum {
    public int[] maxMin(String[] operations, int[] x) {
        int n = operations.length;
        int[] res = new int[n];
        var treeMap = new TreeMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            if (operations[i].equals("push")) {
                treeMap.put(x[i], treeMap.getOrDefault(x[i], 0) + 1);
            } else {
                treeMap.put(x[i], treeMap.get(x[i]) - 1);
                treeMap.remove(x[i], 0);
            }

            int max = treeMap.lastKey();
            int min = treeMap.firstKey();
            res[i] = max * min;
        }

        return res;
    }

    public static void main(String[] args) {
        ProductOfMaximumAndMinimum obj = new ProductOfMaximumAndMinimum();
        String[] operations = { "push", "push", "push", "pop" };
        int[] x = { 1, 2, 3, 1 };
        int[] res = obj.maxMin(operations, x);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
