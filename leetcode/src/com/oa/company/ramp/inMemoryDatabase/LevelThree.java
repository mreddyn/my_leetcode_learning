package com.oa.company.ramp.inMemoryDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LevelThree {
    private static class FieldValue {
        String value;
        long timestamp;
        Long ttl;

        FieldValue(String value, long timestamp, Long ttl) {
            this.timestamp = timestamp;
            this.value = value;
            this.ttl = ttl;
        }

        boolean isValid(long currentTime) {
            return ttl == null || currentTime < timestamp + ttl;
        }
    }

    private Map<String, Map<String, FieldValue>> database;
    private long currentTime;

    public LevelThree() {
        this.database = new HashMap<>();
        this.currentTime = 0;
    }

    public String setAt(String key, String field, String value, long timestamp) {
        advanceTime(timestamp);
        Map<String, FieldValue> record = this.database.getOrDefault(key, new HashMap<>());
        record.put(field, new FieldValue(value, timestamp, null));
        database.put(key, record);
        return "";
    }

    public String setAtWithTTL(String key, String field, String value, long timestamp, Long ttl) {
        advanceTime(timestamp);
        Map<String, FieldValue> record = this.database.getOrDefault(key, new HashMap<>());
        record.put(field, new FieldValue(value, timestamp, ttl));
        database.put(key, record);
        return "";
    }

    public String getAt(String key, String field, long timestamp) {
        advanceTime(timestamp);
        Map<String, FieldValue> record = this.database.get(key);
        if (record == null || !record.containsKey(field) || !record.get(key).isValid(timestamp)) {
            return "";
        }
        return record.get(field).value;
    }

    public String deleteAt(String key, String field, long timestamp) {
        advanceTime(timestamp);
        Map<String, FieldValue> record = this.database.get(key);
        if (record == null || !record.containsKey(field) || !record.get(field).isValid(timestamp)) {
            return "false";
        }
        record.remove(field);
        if (record.isEmpty()) {
            database.remove(key);
        }
        return "true";
    }

    public String scanAt(String key, long timestamp) {
        advanceTime(timestamp);
        Map<String, FieldValue> record = database.get(key);
        if (record == null) {
            return "";
        }
        return record.entrySet().stream()
                .filter(entry -> entry.getValue().isValid(currentTime))
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "(" + entry.getValue().value + ")")
                .collect(Collectors.joining(", "));
    }

    public String scanByPrefixAt(String key, String prefix, long timestamp) {
        advanceTime(timestamp);
        Map<String, FieldValue> record = database.get(key);
        if (record == null) {
            return "";
        }
        return record.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith(prefix) && entry.getValue().isValid(currentTime))
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "(" + entry.getValue().value + ")")
                .collect(Collectors.joining(", "));
    }

    // advance the currentTime
    private void advanceTime(long newTime) {
        if (newTime > this.currentTime) {
            this.currentTime = newTime;
            cleanUpExpiredEntries();
        }
    }

    // clean up expired entries
    private void cleanUpExpiredEntries() {
        for (String key : new HashMap<>(database).keySet()) {
            Map<String, FieldValue> record = database.get(key);
            record.entrySet().removeIf(entry -> !entry.getValue().isValid(currentTime));
            if (record.isEmpty()) {
                database.remove(key);
            }
        }
    }

}
