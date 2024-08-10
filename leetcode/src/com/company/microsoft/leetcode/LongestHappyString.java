package com.company.microsoft.leetcode;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c){
        int A, B, C, n;
        A = B = C = 0;
        n = a + b + c;
        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            if((a >= b && a >= c && A != 2) || (A != 2 && B == 2 && a > 0) || (A != 2 && C == 2 && a > 0)){
                A++;
                a--;
                sb.append('a');
                B = 0;
                C = 0;
            }
            else if((b >= a && b >= c && B != 2) || (B != 2 && A == 2 && b > 0) || (B != 2 && C == 2 && b > 0)){
                B++;
                b--;
                sb.append('b');
                A = 0;
                C = 0;
            }
            else if((c >= b && c >= a && C != 2) || (C != 2 && A == 2 && c > 0) || (C != 2 && B == 2 && c > 0)){
                C++;
                c--;
                sb.append('c');
                A = 0;
                B = 0;
            }
            
        }
        return sb.toString();
    }
    public static void main(String[] args){
        LongestHappyString longestHappyString = new LongestHappyString();
        System.out.println(longestHappyString.longestDiverseString(1, 1, 7));
        System.out.println(longestHappyString.longestDiverseString(7, 1, 0));

    }
}
