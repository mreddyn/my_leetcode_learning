package com.company.amazon.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    private Map<String, List<ValueStore>> timeBasedStoreMap;

    public TimeBasedKeyValueStore() {
        timeBasedStoreMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeBasedStoreMap.containsKey(key)) {
            timeBasedStoreMap.put(key, new ArrayList<>());
        }
        List<ValueStore> list = timeBasedStoreMap.get(key);
        list.add(new ValueStore(value, timestamp));
        timeBasedStoreMap.put(key, list);
    }

    public String get(String key, int timestamp) {
        if (!timeBasedStoreMap.containsKey(key)) {
            return "";
        }
        List<ValueStore> list = timeBasedStoreMap.get(key);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int timestampPrev = list.get(mid).timestamp;
            if (timestampPrev == timestamp) {
                return list.get(mid).value;
            }
            if (timestampPrev < timestamp) {
                if (list.get(mid + 1).timestamp > timestamp) {
                    return list.get(mid).value;
                }
                left = mid + 1;
            } else {
                right = mid + 1;
            }
        }

        return list.get(left).timestamp <= timestamp ? list.get(left).value : "";
    }

    class ValueStore {
        String value;
        int timestamp;

        public ValueStore(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
