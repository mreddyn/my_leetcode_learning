package com.oa.company.rippling.in_memory_key_value_store;

import java.util.HashMap;
import java.util.Map;

public class InMemoryKeyValueStore {
    private final Map<String, String> store;

    public InMemoryKeyValueStore() {
        store = new HashMap<>();
    }

    public String get(String key) {
        return store.get(key);
    }

    public void set(String key, String value) {
        store.put(key, value);
    }

    public void remove(String key) {
        store.remove(key);
    }

    public static void main(String[] args) {
        InMemoryKeyValueStore keyValueStore = new InMemoryKeyValueStore();
        keyValueStore.set("key1", "value1");
        keyValueStore.set("key2", "value2");
        System.out.println(keyValueStore.get("key1"));
        keyValueStore.remove("key1");
        System.out.println(keyValueStore.get("key1"));
    }
}
