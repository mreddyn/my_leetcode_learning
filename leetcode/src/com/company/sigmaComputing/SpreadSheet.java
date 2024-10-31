package com.company.sigmaComputing;

import java.util.*;

public class SpreadSheet {
    private List<String> columns;
    private Map<Integer, Map<String, Integer>> data;

    public SpreadSheet(String... columnNames) {
        columns = Arrays.asList(columnNames);
        data = new HashMap<>();
    }

    public void set(int rowNumber, String columnName, int value) {
        if (!columns.contains(columnName)) {
            throw new IllegalArgumentException("Invalid column name: " + columnName);
        }
        Map<String, Integer> row = data.get(rowNumber);
        if (row == null) {
            row = new HashMap<>();
            data.put(rowNumber, row);
        }
        row.put(columnName, value);
    }

    public int get(int rowNumber, String columnName) {
        if (!columns.contains(columnName)) {
            throw new IllegalArgumentException("Invalid column name: " + columnName);
        }
        Map<String, Integer> row = data.get(rowNumber);
        if (row != null && row.containsKey(columnName)) {
            return row.get(columnName);
        } else {
            return 0;
        }
    }

    public void printFirstNLine(int n) {
        for (int rowNumber = 0; rowNumber < n; rowNumber++) {
            System.out.print(rowNumber + " ->");
            for (String columnName : columns) {
                int value = get(rowNumber, columnName);
                System.out.print(" " + value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SpreadSheet spreadSheet = new SpreadSheet("a", "b", "c");
        spreadSheet.set(0, "a", 1);
        spreadSheet.set(0, "b", 2);
        spreadSheet.set(0, "c", 3);
        spreadSheet.set(1, "a", 4);
        spreadSheet.set(1, "b", 5);
        spreadSheet.set(1, "c", 6);

        System.out.println("spreadSheet.get(0, \"c\") -> " + spreadSheet.get(0, "c"));
        System.out.println("spreadSheet.get(4, \"c\") -> " + spreadSheet.get(4, "c"));

        spreadSheet.printFirstNLine(3);
    }
}
