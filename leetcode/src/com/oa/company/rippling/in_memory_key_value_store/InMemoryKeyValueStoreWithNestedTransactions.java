package com.oa.company.rippling.in_memory_key_value_store;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class InMemoryKeyValueStoreWithNestedTransactions {
    private final Map<String, String> store;

    // Stack of transaction maps to support nested transactions
    // top of stack is the current transaction
    private final Deque<Map<String, String>> transactionStack;

    public InMemoryKeyValueStoreWithNestedTransactions() {
        store = new HashMap<>();
        transactionStack = new ArrayDeque<>();
    }

    public String get(String key) {
        for (var transaction : transactionStack) {
            if (transaction.containsKey(key)) {
                return transaction.get(key);
            }
        }
        return store.get(key);
    }

    public void set(String key, String value) {
        if (transactionStack.isEmpty()) {
            store.put(key, value);
        } else {
            transactionStack.peek().put(key, value);
        }
    }

    public void remove(String key) {
        if (transactionStack.isEmpty()) {
            store.remove(key);
        } else {
            transactionStack.peek().put(key, null);
        }
    }

    public void start() {
        transactionStack.push(new HashMap<>());
    }

    // commit top transaction's changes to the next transaction or the main store
    public void commit() {
        if (transactionStack.isEmpty()) {
            throw new IllegalStateException("No transaction in progress");
        }

        var currentTransaction = transactionStack.pop();
        if (transactionStack.isEmpty()) {
            // apply transaction changes to the main store
            applyChangesToStore(currentTransaction, store);
        } else {
            // apply transaction changes to the next transaction
            applyChangesToStore(currentTransaction, transactionStack.peek());
        }
    }

    private void applyChangesToStore(Map<String, String> source, Map<String, String> destination) {
        for (var entry : source.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (value == null) {
                destination.remove(key);
            } else {
                destination.put(key, value);
            }
        }
    }

    public void rollback() {
        if (transactionStack.isEmpty()) {
            throw new IllegalStateException("No transaction in progress");
        }
        transactionStack.pop();
    }

    public static void main(String[] args) {
        InMemoryKeyValueStoreWithNestedTransactions kvStore = new InMemoryKeyValueStoreWithNestedTransactions();

        kvStore.set("name", "Alice");

        // 1. Start an outer transaction
        kvStore.start();
        kvStore.set("name", "Bob");
        System.out.println(kvStore.get("name")); // Bob (from transaction #1)

        // 2. Start a nested transaction
        kvStore.start();
        kvStore.set("name", "Charlie");
        System.out.println(kvStore.get("name")); // Charlie (from transaction #2)

        // 3. Commit nested transaction
        kvStore.commit();
        // Now the outer transaction (#1) has "name" = "Charlie"

        System.out.println(kvStore.get("name")); // Charlie (from transaction #1)

        // 4. Rollback the outer transaction
        kvStore.rollback();
        // Now "name" reverts to whatever it was before transaction #1 started (Alice)

        System.out.println(kvStore.get("name")); // Alice

    }
}
