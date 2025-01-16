package com.oa.company.rippling.in_memory_key_value_store;

import java.util.HashMap;
import java.util.Map;

public class InMemoryKeyValueStoreWithTransaction {
    private final Map<String, String> store;

    // a transaction map that holds modifications after start()
    private Map<String, String> transactionStore;

    // a transaction flag to indicate if a transaction is in progress
    private boolean inTransaction;

    public InMemoryKeyValueStoreWithTransaction() {
        store = new HashMap<>();
        transactionStore = null;
        inTransaction = false;
    }

    public String get(String key) {
        if (inTransaction && transactionStore.containsKey(key)) {
            // if key was modified during transaction, return the modified value
            return transactionStore.get(key);
        }
        return store.get(key);
    }

    public void set(String key, String value) {
        if (inTransaction) {
            transactionStore.put(key, value);
        } else {
            store.put(key, value);
        }
    }

    public void remove(String key) {
        if (inTransaction) {
            transactionStore.remove(key);
        } else {
            store.remove(key);
        }
    }

    public void start() {
        if (inTransaction) {
            throw new IllegalStateException("Transaction already in progress");
        }
        inTransaction = true;
        transactionStore = new HashMap<>();
    }

    public void commit() {
        if (!inTransaction) {
            throw new IllegalStateException("No transaction in progress");
        }
        // apply transaction changes to the main store
        for (var entry : transactionStore.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (value == null) {
                store.remove(key);
            } else {
                store.put(key, value);
            }
        }

        // clear transaction store and reset transaction flag
        transactionStore = null;
        inTransaction = false;
    }

    public void rollback() {
        if (!inTransaction) {
            throw new IllegalStateException("No transaction in progress");
        }
        // clear transaction store and reset transaction flag
        transactionStore = null;
        inTransaction = false;
    }

    public static void main(String[] args) {
        InMemoryKeyValueStoreWithTransaction keyValueStore = new InMemoryKeyValueStoreWithTransaction();
        keyValueStore.set("key1", "value1");
        keyValueStore.set("key2", "value2");
        System.out.println(keyValueStore.get("key1"));
        keyValueStore.start();
        keyValueStore.set("key1", "value3");
        System.out.println(keyValueStore.get("key1"));
        keyValueStore.rollback();
        System.out.println(keyValueStore.get("key1"));
        keyValueStore.start();
        keyValueStore.set("key1", "value3");
        System.out.println(keyValueStore.get("key1"));
        keyValueStore.commit();
        System.out.println(keyValueStore.get("key1"));
    }
}
