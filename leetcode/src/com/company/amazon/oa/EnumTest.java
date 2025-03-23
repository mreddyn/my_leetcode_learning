package com.company.amazon.oa;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(Color.RED);
        for (Color color : Color.values()) {
            System.out.println(color.ordinal() + " " + color);
        }
    }

    enum Color {
        RED, GREEN, BLUE;
    }
}
