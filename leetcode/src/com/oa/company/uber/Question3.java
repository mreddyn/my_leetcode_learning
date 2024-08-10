package com.oa.company.uber;

public class Question3 {
    private static int solution(int[][] matrix) {
        int n;
        n = matrix.length;
        int yTotalLength, totalCount, yMaxElement;
        int a[] = new int[3];
        yTotalLength = 0;
        totalCount = 0;
        // find elements in Y
        for (int i = 0; i < n / 2; i++) { // left segment
            yTotalLength++;
            a[matrix[i][i]]++;
            matrix[i][i] = -3;
        }
        for (int i = 0,j=n-1; i < n / 2; i++,j--) { // right segment
            yTotalLength++;
            a[matrix[i][j]]++;
            matrix[i][j] = -3;
        }
        for (int i = n/2, j=n/2; i < n; i++) { // mid segment
            yTotalLength++;
            a[matrix[i][j]]++;
            matrix[i][j] = -3;
        }
        yMaxElement = Math.max(Math.max(a[0], a[1]), a[2]);
        return 0;
    }

    public static void main(String[] args) {

    }
}
