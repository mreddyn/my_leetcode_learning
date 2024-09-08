package com.oa.company.ramp;

public class RemoveUnderScoreFromMiddle {
    private String removeUnderscore(String s) {
        // iterate from the rear and skip the trailing underscores.
        // keep track of last seen lowercase letter, if underscore encountered then
        // convert lowercase alphabet to
        // uppercase
        int n = s.length(), firstAlphabetFromLeft = 0, firstAlphabetFromRight = 0;
        char[] ch = s.toCharArray();
        // skip leading underscores
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '_') {
                continue;
            } else {
                firstAlphabetFromLeft = i;
                break;
            }
        }

        // skip trailing underscores
        for (int i = n - 1; i > firstAlphabetFromLeft; i--) {
            if (s.charAt(i) == '_') {
                continue;
            } else {
                firstAlphabetFromRight = i;
                break;
            }
        }

        // if you see a underscore then change the char right next to it to uppercase
        for (int i = firstAlphabetFromRight; i > firstAlphabetFromLeft; i--) {
            if (ch[i] != '_') {
                continue;
            } else {
                if (ch[i + 1] == '_' || (ch[i] >= 97 && ch[i] <= 122)) {
                    continue;
                } else {
                    ch[i + 1] = (char) (ch[i + 1] - 32);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstAlphabetFromLeft; i++) {
            sb.append('_');
        }
        for (int i = firstAlphabetFromLeft; i <= firstAlphabetFromRight; i++) {
            if (ch[i] != '_') {
                sb.append(ch[i]);
            }
        }
        for (int i = firstAlphabetFromRight + 1; i < n; i++) {
            sb.append('_');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveUnderScoreFromMiddle removeUnderScoreFromMiddle = new RemoveUnderScoreFromMiddle();
        System.out.println(removeUnderScoreFromMiddle.removeUnderscore("__variable_one__ _variable_two variable_three"));
        System.out.println(removeUnderScoreFromMiddle.removeUnderscore("___leet___code__"));
        System.out.println(removeUnderScoreFromMiddle.removeUnderscore("___leet_co_de__"));
    }
}
