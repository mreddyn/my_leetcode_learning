package com.leetcode.easy;

public class MinimumMovesToConvertString {
    public int minimumMoves(String s) {
        int n = s.length(), moves = 0, xCount = 0, window = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'X') {
                xCount++;
            }

            if (xCount > 0) {
                window++;
            }

            if (window == 3) {
                moves++;
                window = 0;
                xCount = 0;
            }
        }

        if (window > 0) {
            moves++;
        }

        return moves;
    }

    public int minimumMovesApproachTwo(String s) {
        /*
         * we need to change a all X's into O. But changing X individually is waste of
         * time.
         * Once we find an X we can skip next two chars because we don't care if the
         * next two chars
         * are XX or XO or OX or OO, since three consecutive chars can be changed in one
         * move.
         * So whenever we encounter an X we skip next two chars, else we move only one
         * step.
         */
        int n = s.length(), moves = 0, index = 0;
        while (index < n) {
            if (s.charAt(index) == 'X') {
                index = index + 3;
                moves++;
            } else {
                index++;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        MinimumMovesToConvertString mString = new MinimumMovesToConvertString();
        System.out.println(mString.minimumMoves("XXX"));
        System.out.println(mString.minimumMoves("XXOX"));
        System.out.println(mString.minimumMoves("XXXOXX"));
        System.out.println(mString.minimumMoves("OXOX"));
    }
}
