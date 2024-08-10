package com.oa.company.ramp;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryDatabase {

    private Map<String, Map<String, String>> database;

    public InMemoryDatabase() {
        this.database = new HashMap<>();
    }

    public String set(String key, String field, String value) {
        Map<String, String> record = database.getOrDefault(key, new HashMap<>());
        record.put(field, value);
        database.put(key, record);
        return "";
    }

    public String get(String key, String field) {
        Map<String, String> record = database.get(key);
        if (record == null || !record.containsKey(field)) {
            return "";
        }
        return record.get(field);
    }

    public String delete(String key, String field) {
        Map<String, String> record = database.get(key);
        if (record == null || !record.containsKey(field)) {
            return "false";
        }
        record.remove(field);
        if (record.isEmpty()) {
            database.remove(key);
        }
        return "true";
    }

    // level 2 SCAN and SCAN_BY_PREFIX
    public String scan(String key) {
        Map<String, String> record = database.get(key);
        if (record == null) {
            return "";
        }
        return record.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "(" + entry.getValue() + ")")
                .collect(Collectors.joining(", "));
    }

    public String scanByPrefix(String key, String prefix) {
        Map<String, String> record = database.get(key);
        if (record == null) {
            return "";
        }
        return record.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith(prefix))
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "(" + entry.getValue() + ")")
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        System.out.println(inMemoryDatabase.set("A", "B", "E"));
        System.out.println(inMemoryDatabase.set("A", "C", "F"));
        System.out.println(inMemoryDatabase.get("A", "B"));
        System.out.println(inMemoryDatabase.get("A", "D"));
        System.out.println(inMemoryDatabase.scan("A"));
        System.out.println(inMemoryDatabase.scanByPrefix("A", "B"));
        System.out.println(inMemoryDatabase.delete("A", "B"));
        System.out.println(inMemoryDatabase.delete("A", "D"));
    }
}
