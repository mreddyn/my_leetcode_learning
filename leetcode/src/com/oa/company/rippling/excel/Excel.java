package com.oa.company.rippling.excel;

import java.util.ArrayList;
import java.util.List;

public class Excel {
    // the numeric values of the cells
    private int[][] values;

    // the formulas of the cells
    // If a cell is defined by sum(...), store the list of (row, col) references
    // here.
    // Otherwise, keep it null to indicate it's a direct-value cell.
    private List<int[]>[][] formulas;
    private int height;
    private int width;

    public Excel(int height, char width) {
        this.height = height;
        this.width = width - 'A' + 1;
        values = new int[this.height][this.width];
        formulas = new ArrayList[this.height][this.width];
    }

    public void set(int row, char column, int val) {
        int col = column - 'A';
        row = row - 1;
        values[row][col] = val;
        formulas[row][col] = null;
    }

    public int get(int row, char column) {
        int col = column - 'A';
        row = row - 1;
        if (formulas[row][col] == null) {
            return values[row][col];
        } else {
            return getValue(row, col);
        }
    }

    public int sum(int row, char column, String[] numbers) {
        int col = column - 'A';
        row = row - 1;
        formulas[row][col] = new ArrayList<>();
        for (String num : numbers) {
            formulas[row][col].addAll(parseReference(num));
        }
        return getValue(row, col);
    }

    private int getValue(int row, int col) {
        // if the cell does not have a formula, return the value
        if (formulas[row][col] == null) {
            return values[row][col];
        }
        // otherwise, calculate the value from references
        int sum = 0;
        for (var ref : formulas[row][col]) {
            sum += getValue(ref[0], ref[1]);
        }

        // store the computed value in the values array
        values[row][col] = sum;
        return sum;
    }

    /**
     * Parse a reference string:
     * - If it's a single cell like "A1", return a List with just that one cell.
     * - If it's a range like "B3:F7", return a List of all cells in that rectangle.
     */
    private List<int[]> parseReference(String ref) {
        var result = new ArrayList<int[]>();
        if (ref.indexOf(':') == -1) {
            // single cell
            result.add(parseCell(ref));
        } else {
            // range
            String[] parts = ref.split(":");
            int[] start = parseCell(parts[0]);
            int[] end = parseCell(parts[1]);
            for (int row = start[0]; row <= end[0]; row++) {
                for (int col = start[1]; col <= end[1]; col++) {
                    result.add(new int[] { row, col });
                }
            }
        }

        return result;
    }

    private int[] parseCell(String cellRef) {
        // Example: "A1", "C12", etc.
        // 1) Separate letters from digits.
        // 2) Convert letters (e.g. 'A') to col index, digits to row index.
        // For single-letter columns, the column part is the first character; the rest
        // is row.

        // If you need more robust logic for multi-letter columns (e.g. "AB10"),
        // you'll have to parse differently. This is a simplified approach.
        int col = cellRef.charAt(0) - 'A';
        int row = Integer.parseInt(cellRef.substring(1)) - 1;
        return new int[] { row, col };
    }
}
