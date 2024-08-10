package com.oa.company.amazon;

import java.util.HashMap;

public class RedundantSubStringsCount {
    private HashMap<Character, Boolean> vowelMap;

    public int getRedundantSubStrings(String s) {
        initVowelMap();
        

        return 0;
    }

    private void initVowelMap() {
        vowelMap = new HashMap<>(5);
        vowelMap.put('a', true);
        vowelMap.put('e', true);
        vowelMap.put('i', true);
        vowelMap.put('o', true);
        vowelMap.put('u', true);
    }
}
