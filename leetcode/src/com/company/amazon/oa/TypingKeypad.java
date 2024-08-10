package com.company.amazon.oa;

import java.util.HashMap;
import java.util.Map;

public class TypingKeypad {
    public static int minimumKeypadClickCount(String s){
        int n;
        n = s.length();
        if(n <= 9){
            return n;
        }
        int count[] = new int[9];
        Map<Character, Integer> map = new HashMap<>();
        int index;
        index = 0;
        for(int i = 0;i < n; i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                if(index == 9){
                    index =  0;
                }
                count[index]++;
                map.put(ch, count[index]);
                index++;
            }
        }
        System.out.println(map);
        int clickCount = 0;
        for(int i=0;i<n;i++){
            clickCount += map.get(s.charAt(i));
        }
        return clickCount;
    }
    public static void main(String[] args) {
        System.out.println(minimumKeypadClickCount("abcghdiefjoba"));
    }
}
