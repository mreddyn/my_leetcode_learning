package com.oa.company.microsoft.hiringevent;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    Map<String, Integer> map = new HashMap<>();

    public int getLengthOfOptimalCompression(String s, int k) {

        return compress(s.toCharArray(), 0, '*', 0, k);

    }

    public int compress(char[] cs, int start, char pre, int count, int k) {
        if (map.containsKey(start + ":" + pre + count + ":" + k))
            return map.get(start + ":" + pre + count + ":" + k);// cache, to improve speed
        if (k < 0)
            return Integer.MAX_VALUE / 2;
        if (start >= cs.length)
            return 0;
        if (pre == cs[start]) {
            int incr = 0;
            if (count == 1 || count == 9 || count == 99) {
                incr = 1;
            }
            int v = incr + compress(cs, start + 1, pre, count + 1, k);// for example we get a range of chars are the
                                                                      // same , "aa"->"aaa", we should increase count
            map.put(start + ":" + pre + count + ":" + k, v);
            return v;
        } else {
            int keep = 1 + compress(cs, start + 1, cs[start], 1, k);// update previous
            int delete = compress(cs, start + 1, pre, count, k - 1);
            int v = Math.min(keep, delete);
            map.put(start + ":" + pre + count + ":" + k, v);
            return v;
        }
    }
}
