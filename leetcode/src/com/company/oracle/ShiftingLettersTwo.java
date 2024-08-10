package com.company.oracle;

public class ShiftingLettersTwo {
    private char[] letters;

    private String shiftingLetters(String s, int[][] shifts) {
        char[] ch = s.toCharArray();
        letters = new char[26];
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            letters[index++] = c;
        }
        int[] shift = new int[ch.length + 1];
        for (int[] sh : shifts) {
            int startIndex = sh[0];
            int endIndex = sh[1];
            int direction = sh[2];
            int value = direction == 1 ? 1 : -1;
            shift[startIndex] += value;
            shift[endIndex + 1] -= value;
        }
        int previousShifts = 0;
        for (int i = 0; i < shift.length - 1; i++) {
            previousShifts += shift[i];
            ch[i] = shiftCharacter(ch[i], previousShifts % 26);
        }
        return new String(ch);
    }

    private char shiftCharacter(char c, int positions) {
        int index = (c - 'a' + positions) % 26;
        if (index < 0) {
            index = index + 26;
        }
        return letters[index];
    }

    public static void main(String[] args) {
        ShiftingLettersTwo shiftingLettersTwo = new ShiftingLettersTwo();
        System.out.println(
                shiftingLettersTwo.shiftingLetters("dztz", new int[][] { { 0, 0, 0 }, { 1, 1, 1 } }));
        ;
    }
}
