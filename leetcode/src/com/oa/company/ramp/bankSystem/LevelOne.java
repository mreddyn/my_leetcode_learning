package com.oa.company.ramp.bankSystem;

import java.util.HashMap;
import java.util.Map;

public class LevelOne {
    private Map<String, Long> accounts;

    LevelOne() {
        this.accounts = new HashMap<>();
    }

    public String createAccount(String timestamp, String accountId) {
        if (accounts.containsKey(accountId)) {
            return "false";
        }
        accounts.put(accountId, 0L);
        return "true";
    }

    public String deposit(String timestamp, String accountId, long amount) {
        if (!accounts.containsKey(accountId)) {
            return "";
        }
        long newBalance = accounts.get(accountId) + amount;
        accounts.put(accountId, newBalance);
        return String.valueOf(newBalance);
    }

    public String pay(String timestamp, String accountId, long amount) {
        if (!accounts.containsKey(accountId)) {
            return "";
        }
        if (accounts.get(accountId) < amount) {
            return "";
        }
        long newBalance = accounts.get(accountId) - amount;
        accounts.put(accountId, newBalance);
        return String.valueOf(newBalance);

    }

    public static void main(String[] args) {
        LevelOne levelOne = new LevelOne();
        System.out.println(levelOne.createAccount("1", "account1"));
        System.out.println(levelOne.createAccount("2", "account2"));
        System.out.println(levelOne.createAccount("3", "account3"));
        System.out.println(levelOne.createAccount("4", "account1"));
        System.out.println(levelOne.deposit("5", "account1", 2000));
        System.out.println(levelOne.deposit("6", "account2", 200));
        System.out.println(levelOne.pay("7", "account1", 2001));
        System.out.println(levelOne.pay("8", "account1", 1500));

    }
}
