package com.company.servicenow;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recurse(result, 0, 0, "", n);
        return result;
    }

    private void recurse(List<String> result, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            result.add(s);
            return;
        }
        if (left < n) {
            recurse(result, left + 1, right, s + "(", n);
        }
        if (right < left) {
            recurse(result, left, right + 1, s + ")", n);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(4));
    }
}
