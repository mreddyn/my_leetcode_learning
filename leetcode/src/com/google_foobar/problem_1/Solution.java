package com.google_foobar.problem_1;

public class Solution {
    public static String solution(String x){
        int n;
        n = x.length();
        char ch[] = x.toCharArray();
        for(int i=0;i<n;i++){
            ch[i] = (ch[i] >=97 && ch[i]<=122)?   (char)((25 - (ch[i] - 'a'))+97) : ch[i];
        }
        return new String(ch);
    }
    public static void main(String[] args) {
        System.out.println(solution("Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!"));
    }
}
