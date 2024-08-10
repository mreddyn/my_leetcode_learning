package com.oa.company.visa;

public class Question4 {
    private static int[] solution(String binaryString, String []requests){
        int n;
        n = requests.length;
        char ch[] = binaryString.toCharArray();
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            if(requests[i].equals("count")){
                res[i] = countOnes(ch);
            }
            else{
                res[i] = firstZero(ch);
                flip(ch, res[i]);
            }
        }
        return res;
    }
    private static int countOnes(char ch[]){
        int n, ones;
        ones = 0;
        n = ch.length;
        for(int i=0;i<n;i++){
            if(ch[i] == '1'){
                ones++;
            }
        }
        return ones;
    }
    private static int firstZero(char ch[]){
        int n, index;
        index = 0;
        n = ch.length;
        for(int i=0;i<n;i++){
            if(ch[i] == '0'){
                index = i;
                break;
            }
        }
        return index;
    }
    private static void flip(char ch[], int index){
        int n;
        n = ch.length;
        for(int i=0;i<=index;i++){
            if(ch[i] == '1'){
                ch[i] = '0';
            }
            else{
                ch[i] = '1';
            }
        }
        return;
    }
    public static void main(String[] args) {
        System.out.println(solution("101000", new String[]{"count","flip","flip","flip","count"}));
    }
}
