package com.oa.company.amazon;

import java.util.HashMap;
import java.util.Map;

public class StudyCCOM {
    private Map<String, Integer> map;

    public StudyCCOM() {

        map = new HashMap<>();

        map.put("foo", 1);

        map.put("bar", 3);

    }

    public int getValue(String input, int numRetries) throws Exception {

        try {

            return map.get(input);

        }

        catch (Exception e) {

            if (numRetries > 3) {

                throw e;

            }

            return getValue(input, numRetries + 1);

        }

    }

    public static void main(String[] args) throws Exception {
        StudyCCOM studyCCOM = new StudyCCOM();
        System.out.println(studyCCOM.getValue("foo", 0));
        System.out.println(studyCCOM.getValue("bar", 2));
        System.out.println(studyCCOM.getValue("baz", 0));
        System.out.println(studyCCOM.getValue("fubar", 1));
    }
}
