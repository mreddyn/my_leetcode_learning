package com.company.sigmaComputing;

import java.util.*;

public class PivotTableGenerator {

    public static Map<String, Map<String, Integer>> generatePivotTable(
            List<Map<String, Object>> dataTable,
            String aggregateColumn,
            String xAxisColumn,
            String yAxisColumn) {

        // Set to store all unique x-axis values
        Set<String> xAxisValues = new TreeSet<>();
        // Map to store the pivot table data
        Map<String, Map<String, Integer>> pivotTable = new TreeMap<>();

        for (Map<String, Object> row : dataTable) {
            String xValue = row.get(xAxisColumn).toString();
            String yValue = row.get(yAxisColumn).toString();
            int aggregateValue = Integer.parseInt(row.get(aggregateColumn).toString());

            xAxisValues.add(xValue);

            // Get or create the row for the y-axis value
            Map<String, Integer> rowMap = pivotTable.computeIfAbsent(yValue, k -> new HashMap<>());

            // Aggregate the value
            rowMap.put(xValue, rowMap.getOrDefault(xValue, 0) + aggregateValue);
        }

        // Ensure all x-axis values are present for each y-axis entry
        for (Map<String, Integer> rowMap : pivotTable.values()) {
            for (String xValue : xAxisValues) {
                rowMap.putIfAbsent(xValue, 0);
            }
        }

        return pivotTable;
    }

    public static void printPivotTable(
            Map<String, Map<String, Integer>> pivotTable,
            String aggregateColumn,
            String xAxisColumn,
            String yAxisColumn) {

        // Get all unique x-axis values
        Set<String> xAxisValues = new TreeSet<>();
        for (Map<String, Integer> rowMap : pivotTable.values()) {
            xAxisValues.addAll(rowMap.keySet());
        }

        // Print header
        System.out.printf("%-20s", aggregateColumn);
        for (String xValue : xAxisValues) {
            System.out.printf("%15s", xValue);
        }
        System.out.println();

        // Print rows
        for (Map.Entry<String, Map<String, Integer>> entry : pivotTable.entrySet()) {
            String yValue = entry.getKey();
            Map<String, Integer> rowMap = entry.getValue();
            System.out.printf("%-20s", yValue);
            for (String xValue : xAxisValues) {
                int value = rowMap.getOrDefault(xValue, 0);
                System.out.printf("%15d", value);
            }
            System.out.println();
        }
    }

    // Sample data and test
    public static void main(String[] args) {
        List<Map<String, Object>> dataTable = new ArrayList<>();

        // Sample data
        dataTable.add(createRow("abcd1234", "2021-05-25", "red", "M", 1));
        dataTable.add(createRow("abcd1234", "2021-05-25", "blue", "L", 620));
        dataTable.add(createRow("abcd1234", "2021-05-25", "green", "S", 307));
        dataTable.add(createRow("5678wxyz", "2021-05-25", "black", "L", 80));
        dataTable.add(createRow("abcd1234", "2021-05-26", "red", "M", 5));
        dataTable.add(createRow("5678wxyz", "2021-05-26", "blue", "S", 900));
        dataTable.add(createRow("abcd1234", "2021-05-27", "black", "M", 20));

        // Generate pivot table
        Map<String, Map<String, Integer>> pivotTable = generatePivotTable(
                dataTable,
                "Shirts sold",
                "Date",
                "Color");

        // Print pivot table
        printPivotTable(pivotTable, "Sum of shirts sold", "Date", "Color");
    }

    private static Map<String, Object> createRow(
            String storeId,
            String date,
            String color,
            String size,
            int shirtsSold) {
        Map<String, Object> row = new HashMap<>();
        row.put("Store ID", storeId);
        row.put("Date", date);
        row.put("Color", color);
        row.put("Size", size);
        row.put("Shirts sold", shirtsSold);
        return row;
    }
}
