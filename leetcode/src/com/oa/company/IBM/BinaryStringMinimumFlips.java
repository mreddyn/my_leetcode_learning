package com.oa.company.IBM;

public class BinaryStringMinimumFlips {
    public int getMinFlips(String s) {
        int minFlips = 0, n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                minFlips++;
            }
        }
        return minFlips;
    }

    public static void main(String[] args) {
        BinaryStringMinimumFlips bFlips = new BinaryStringMinimumFlips();
        System.out.println(bFlips.getMinFlips("1110011000"));
        System.out.println(bFlips.getMinFlips("101011"));
    }
}
