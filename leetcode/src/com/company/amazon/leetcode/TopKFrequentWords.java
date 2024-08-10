package com.company.amazon.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k){
        List<String> resList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b){
                if(map.get(a) == map.get(b)){
                    return a.compareTo(b);
                }
                return map.get(b) - map.get(a);
            }
        };

        PriorityQueue<String> pq = new PriorityQueue<>(customComparator);
        for(String s: map.keySet()){
            pq.add(s);
        }
        while(k-- > 0){
            resList.add(pq.poll());
        }
        return resList;
    }
}
