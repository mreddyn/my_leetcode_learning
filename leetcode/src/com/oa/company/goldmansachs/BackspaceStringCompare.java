package com.oa.company.goldmansachs;

public class BackspaceStringCompare {
    public int compareStrings(String s1, String s2) {
        var ch1 = s1.toCharArray();
        var ch2 = s2.toCharArray();

        String actualS1 = getActualString(ch1);
        String actualS2 = getActualString(ch2);
        return actualS1.equals(actualS2) ? 1 : 0;
    }

    private String getActualString(char[] ch) {
        int n = ch.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == '#' && index > 0) {
                index--;
            } else {
                ch[index] = ch[i];
                index++;
            }
        }

        return new String(ch, 0, index);
    }

    public static void main(String[] args) {
        BackspaceStringCompare obj = new BackspaceStringCompare();
        System.out.println(obj.compareStrings("ab#c", "ad#c")); // 1
        System.out.println(obj.compareStrings("ab##", "c#d#")); // 1
        System.out.println(obj.compareStrings("a##c", "#a#c")); // 1
        System.out.println(obj.compareStrings("a#c", "b")); // 0
    }
}
