package com.oa.company.IBM;

public class CaesarCipher {
    private String rollingString(String s, int n, String[] operations) {
        // same as Shifting Letters.java
        return "";
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        System.out.println(caesarCipher.rollingString("abc", 3, new String[] { "0 0 L", "0 2 L", "2 2 R" }));
    }
}
