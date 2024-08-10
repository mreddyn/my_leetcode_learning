package com.oa.company.visa;

import java.util.*;

/* Online Java Compiler and Editor */
public class HelloWorld{

     public static void main(String []args) {
         HelloWorld obj = new HelloWorld();
         String[] tt = {"12:30", "14:00", "19:55"};
         String time = "14:30";
         System.out.println("res:- " + obj.solution(tt, time));
     }
     
     private int solution(String[] schedule, String time) {
         int index = time.indexOf(":");
         int lastBusTotalMin = Integer.valueOf(time.substring(0, index)) * 60 
         + Integer.valueOf(time.substring(index+1));
        
         int min = Integer.MAX_VALUE; int lastHour = 0, lastMin = 0;
         for (String t : schedule) {
             int i = time.indexOf(":");
             int tHour = Integer.valueOf(t.substring(0, i));
             int tMin = Integer.valueOf(t.substring(i+1));
             int totalMin = tHour * 60 + tMin;
             if (totalMin - lastBusTotalMin > 0) {
                 min = Math.min(min, totalMin - lastBusTotalMin);
                 continue;
             }
            break;
         }
         return min == Integer.MAX_VALUE ? -1 : min;
     }
}