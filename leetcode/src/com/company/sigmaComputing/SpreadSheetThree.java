package com.company.sigmaComputing;

import java.util.*;

public class SpreadSheetThree {

    private Map<String, Cell> cells;

    public SpreadSheetThree() {
        cells = new HashMap<>();
    }

    // Sets the value of a cell, which can be an integer or a formula
    public void set_cell(String cellName, String value) {
        Cell cell = new Cell(value);
        cells.put(cellName, cell);
    }

    // Gets the computed value of a cell, or -1 if a cycle is detected
    public int get_cell(String cellName) {
        if (!cells.containsKey(cellName)) {
            throw new IllegalArgumentException("Cell " + cellName + " does not exist.");
        }
        return evaluateCell(cellName, new HashSet<>());
    }

    // Recursive method to evaluate a cell's value, with cycle detection
    private int evaluateCell(String cellName, Set<String> visited) {
        if (visited.contains(cellName)) {
            // Cycle detected
            return -1;
        }
        visited.add(cellName);

        Cell cell = cells.get(cellName);
        if (cell.isValueComputed()) {
            visited.remove(cellName);
            return cell.getComputedValue();
        }

        String value = cell.getValue();
        int result;

        if (value.startsWith("=")) {
            // It's a formula
            result = evaluateFormula(value.substring(1), visited);
            if (result == -1) {
                cell.setComputedValue(-1);
                visited.remove(cellName);
                return -1;
            }
        } else {
            // It's a numeric value
            try {
                result = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid numeric value in cell " + cellName);
            }
        }

        cell.setComputedValue(result);
        visited.remove(cellName);
        return result;
    }

    // Evaluates a formula string, returns -1 if a cycle is detected
    private int evaluateFormula(String formula, Set<String> visited) {
        try {
            // Tokenize the formula
            String[] tokens = formula.split("(?=[-+*/])|(?<=[-+*/])");
            Stack<Integer> values = new Stack<>();
            Stack<String> operators = new Stack<>();

            for (String token : tokens) {
                token = token.trim();
                if (token.isEmpty())
                    continue;

                if (isOperator(token)) {
                    operators.push(token);
                } else if (isCellReference(token)) {
                    int cellValue = evaluateCell(token, visited);
                    if (cellValue == -1) {
                        return -1; // Cycle detected in referenced cell
                    }
                    values.push(cellValue);
                } else {
                    // It's a numeric value
                    values.push(Integer.parseInt(token));
                }

                // Evaluate if possible
                while (operators.size() > 0 && values.size() >= 2) {
                    int b = values.pop();
                    int a = values.pop();
                    String op = operators.pop();
                    values.push(applyOperator(a, b, op));
                }
            }

            if (values.size() != 1) {
                throw new IllegalArgumentException("Invalid formula syntax: " + formula);
            }

            return values.pop();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error evaluating formula: " + formula, e);
        }
    }

    // Helper method to check if a token is an operator
    private boolean isOperator(String token) {
        return token.matches("[-+*/]");
    }

    // Helper method to apply an operator to two operands
    private int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0)
                    throw new ArithmeticException("Division by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // Helper method to check if a token is a cell reference
    private boolean isCellReference(String token) {
        return token.matches("[A-Z]+[0-9]+");
    }

    // Cell class representing each cell in the spreadsheet
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

    // Main method for testing
    public static void main(String[] args) {
        SpreadSheetThree spreadsheet = new SpreadSheetThree();

        // Basic test cases
        spreadsheet.set_cell("A1", "13");
        spreadsheet.set_cell("A2", "14");
        System.out.println("get_cell(\"A1\") -> " + spreadsheet.get_cell("A1")); // Should print 13

        spreadsheet.set_cell("A3", "=A1+A2");
        System.out.println("get_cell(\"A3\") -> " + spreadsheet.get_cell("A3")); // Should print 27

        // Edge case with cycle detection
        spreadsheet.set_cell("A3", "23");
        spreadsheet.set_cell("A4", "=A3+11");
        System.out.println("get_cell(\"A4\") -> " + spreadsheet.get_cell("A4")); // Should print 34

        spreadsheet.set_cell("A3", "=A4+12");
        System.out.println("get_cell(\"A3\") -> " + spreadsheet.get_cell("A3")); // Should print -1 due to cycle

        // Additional test for complex formula and cycle
        spreadsheet.set_cell("B1", "=A1+A3");
        System.out.println("get_cell(\"B1\") -> " + spreadsheet.get_cell("B1")); // Should print -1 due to cycle through
                                                                                 // A3

        spreadsheet.set_cell("A3", "5");
        System.out.println("get_cell(\"B1\") -> " + spreadsheet.get_cell("B1")); // Should print 18 (13 + 5)

        // Test for invalid formula
        try {
            spreadsheet.set_cell("C1", "=A1+unknown");
            System.out.println("get_cell(\"C1\") -> " + spreadsheet.get_cell("C1"));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Test for division by zero
        try {
            spreadsheet.set_cell("D1", "=10/0");
            System.out.println("get_cell(\"D1\") -> " + spreadsheet.get_cell("D1"));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
