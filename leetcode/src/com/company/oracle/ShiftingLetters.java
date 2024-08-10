package com.company.oracle;

public class ShiftingLetters {
    private char[] letters;

    private String shiftingLetters(String s, int[] shifts) {
        letters = new char[26];
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            letters[index++] = c;
        }
        char[] ch = s.toCharArray();
        long previousShifts = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            previousShifts += shifts[i];
            ch[i] = shiftCharacter(ch[i], (int) (previousShifts % 26));
        }
        return new String(ch);
    }

    private char shiftCharacter(char c, int positions) {
        int index = (c - 'a' + positions) % 26;
        return letters[index];
    }

    public static void main(String[] args) {
        ShiftingLetters shiftingLetters = new ShiftingLetters();
        System.out.println(shiftingLetters.shiftingLetters("aaa", new int[] { 1, 2, 3 }));
    }
}
