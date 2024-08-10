package com.oa.company.visa;

public class Question1 {
    private static int solution(int []numbers, int []nRange){
        int res = Integer.MAX_VALUE;
        int n;
        n = numbers.length;
        for(int i=0;i<n;i++){
            if(numbers[i] >= nRange[0] && numbers[i] <= nRange[1]){
                res = Math.min(res, numbers[i]);
            }
        }
        return (res == Integer.MAX_VALUE)? 0: res;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{11,4,23,9,10}, new int[]{5,12}));
    }
}
