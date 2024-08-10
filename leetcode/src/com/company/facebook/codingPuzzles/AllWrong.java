package com.company.facebook.codingPuzzles;

public class AllWrong {
    private String getWrongAnswers(int N, String C) {
        char[] ch = new char[N];
        for (int i = 0; i < N; i++) {
            if (C.charAt(i) == 'A') {
                ch[i] = 'B';
            } else {
                ch[i] = 'A';
            }
        }
        for (char c : ch) {
            System.out.println(c);
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        AllWrong solution = new AllWrong();
        System.out.println(solution.getWrongAnswers(3, "ABB"));
    }
}
