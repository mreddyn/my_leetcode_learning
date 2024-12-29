package com.leetcode.medium;

public class RotatingTheBox {
    private final char WALL = '*', STONE = '#', NOTHING = '.';

    public char[][] rotateTheBox(char[][] arr) {

        // move everything to the right towards the closest wall
        for (var row : arr) {
            for (int i = row.length - 1, j = i; i >= 0; i--) {
                var c = row[i];
                if (c == WALL) {
                    j = i - 1;
                } else if (c == STONE) {
                    row[i] = NOTHING;
                    row[j--] = STONE;
                }
            }
        }
        // rotate by 90 degrees
        var res = new char[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                res[j][res[0].length - i - 1] = arr[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RotatingTheBox rBox = new RotatingTheBox();
        char[][] box = { { '#', '#', '*', '.', '*', '.' },
                { '#', '#', '#', '*', '.', '.' },
                { '#', '#', '#', '.', '#', '.' } };
        rBox.rotateTheBox(box);
    }
}
