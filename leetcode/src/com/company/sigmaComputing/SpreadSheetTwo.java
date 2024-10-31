package com.company.sigmaComputing;

import java.util.HashMap;
import java.util.Map;

public class SpreadSheetTwo {
    private Map<String, Cell> cells;

    public SpreadSheetTwo() {
        cells = new HashMap<>();
    }

    public void set_cell(String cellName, String value) {
        Cell cell = new Cell(value);
        cells.put(cellName, cell);
    }

    public int get_cell(String cellName) {
        if (!cells.containsKey(cellName)) {
            throw new IllegalArgumentException("Cell " + cellName + " does not exist.");
        }
        return evaluateCell(cellName, new HashMap<>());
    }

    private int evaluateCell(String cellName, Map<String, Boolean> visited) {
        if (visited.getOrDefault(cellName, false)) {
            throw new IllegalArgumentException("Circular reference detected at cell " + cellName);
        }
        visited.put(cellName, true);

        Cell cell = cells.get(cellName);
        if (cell.isValueComputed()) {
            return cell.getComputedValue();
        }

        String value = cell.getValue();
        int result;
        if (value.startsWith("=")) {
            // It's a formula
            result = evaluateFormula(value.substring(1), visited);
        } else {
            // It's a numeric value
            result = Integer.parseInt(value);
        }

        cell.setComputedValue(result);
        visited.put(cellName, false);
        return result;
    }

    private int evaluateFormula(String formula, Map<String, Boolean> visited) {
        String[] tokens = formula.split("\\+");
        int sum = 0;
        for (String token : tokens) {
            token = token.trim();
            if (isCellReference(token)) {
                sum += evaluateCell(token, visited);
            } else {
                sum += Integer.parseInt(token);
            }
        }
        return sum;
    }

    private boolean isCellReference(String token) {
        return token.matches("[A-Z]+[0-9]+");
    }

    private static class Cell {
        private String value;
        private Integer computedValue;

        public Cell(String value) {
            this.value = value;
            this.computedValue = null;
        }

        public String getValue() {
            return value;
        }

        public int getComputedValue() {
            return computedValue;
        }

        public void setComputedValue(int value) {
            this.computedValue = value;
        }

        public boolean isValueComputed() {
            return computedValue != null;
        }
    }

    public static void main(String[] args) {
        SpreadSheetTwo spreadsheet = new SpreadSheetTwo();
        spreadsheet.set_cell("A1", "13");
        spreadsheet.set_cell("A2", "14");
        System.out.println("get_cell(\"A1\") returns " + spreadsheet.get_cell("A1")); // Should print 13

        spreadsheet.set_cell("A3", "=A1+A2");
        System.out.println("get_cell(\"A3\") returns " + spreadsheet.get_cell("A3")); // Should print 27

        // Additional test cases
        spreadsheet.set_cell("A4", "=A3+5");
        System.out.println("get_cell(\"A4\") returns " + spreadsheet.get_cell("A4")); // Should print 32

        spreadsheet.set_cell("A5", "=A1+A2+A3");
        System.out.println("get_cell(\"A5\") returns " + spreadsheet.get_cell("A5")); // Should print 54
    }
}
