package com.leetcode;

public class FindTheStudentThatWillReplaceChalk {
    public int chalkReplacer(int[] chalk, int k) {
        /*
         * Take two pointers one for studentIndex, and other for current chalk required
         * for student
         * whenever the studentIndex goes out of bounds do studentIndex%n to go circular
         * Loop until k >=0 and curRequiredChalk <= k.
         * TO improve further we need to cut some rounds
         */
        int n = chalk.length, curRequiredChalk = 0, studentIndex = 0;
        if (n == 1) {
            return 0;
        }
        long chalkSum = 0;
        for (int i = 0; i < n; i++) {
            chalkSum += chalk[i];
        }

        // if k is too big
        k = (int) (k % chalkSum);
        while (k >= 0) {
            studentIndex = studentIndex % n;
            curRequiredChalk = chalk[studentIndex];
            if (curRequiredChalk <= k) {
                k = k - curRequiredChalk;
                studentIndex++;
            } else {
                break;
            }
        }
        return studentIndex;
    }

    public static void main(String[] args) {
        FindTheStudentThatWillReplaceChalk fChalk = new FindTheStudentThatWillReplaceChalk();
        System.out.println(fChalk.chalkReplacer(new int[] { 5, 1, 5 }, 27));
    }
}
