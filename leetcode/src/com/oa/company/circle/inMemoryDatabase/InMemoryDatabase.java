package com.oa.company.circle.inMemoryDatabase;

import java.util.HashMap;

public class InMemoryDatabase {
    private HashMap<String, HashMap<String, Integer>> records;

    InMemoryDatabase() {
        records = new HashMap<>();
    }

    private String[] parse(String[][] queries) {
        int size = queries.length, index = 0;
        String[] finalResult = new String[size];
        for (String[] query : queries) {
            if (query[0].equals("SET_OR_INC")) {
                String key = query[1];
                String field = query[2];
                int value = Integer.parseInt(query[3]);
                String result = set(key, field, value);
                finalResult[index] = result;
            } else if (query[0].equals("GET")) {
                String key = query[1];
                String field = query[2];
                String result = get(key, field);
                finalResult[index] = result;

            } else if (query[0].equals("DELETE")) {
                String key = query[1];
                String field = query[2];
                String result = delete(key, field);
                finalResult[index] = result;
            }

            index++;
        }
        return finalResult;
    }

    // SET operation
    private String set(String key, String field, Integer value) {
        HashMap<String, Integer> record = records.get(key);
        if (record == null) {
            record = new HashMap<String, Integer>();
            record.put(field, value);
            records.put(key, record);
            return String.valueOf(value);
        } else {
            Integer fieldValue = record.get(field);
            if (fieldValue == null) {
                record.put(field, value);
                return String.valueOf(value);
            } else {
                fieldValue += value;
                record.put(field, fieldValue);
                return String.valueOf(fieldValue);
            }
        }
    }

    // GET operation
    private String get(String key, String field) {
        HashMap<String, Integer> record = records.get(key);
        if (record != null) {
            Integer value = record.get(field);
            if (value != null) {
                return String.valueOf(value);
            }
        }
        return "";
    }

    // DELETE operation
    private String delete(String key, String field) {
        HashMap<String, Integer> record = records.get(key);
        if (record == null) {
            return "false";
        } else {
            record.remove(field);
            return "true";
        }
    }

    public static void main(String[] args) {
        InMemoryDatabase db = new InMemoryDatabase();
        String[][] queries = { { "SET_OR_INC", "worker1", "experience", "4" },
                { "SET_OR_INC", "worker1", "age", "25" },
                { "SET_OR_INC", "age", "worker1", "2" },
                { "GET", "worker1", "age" },
                { "GET", "worker1", "experience" },
                { "GET", "worker1", "height" },
                { "SET_OR_INC", "worker1", "height", "182" },
                { "SET_OR_INC", "worker1", "age", "4" },
                { "SET_OR_INC", "worker1", "experience", "4" },
                { "GET", "worker1", "experience" },
                { "GET", "worker1", "age" },
                { "GET", "worker1", "height" },
                { "GET", "age", "worker1" } };

        /*
         * expected result 
         * ["4",
         * "25",
         * "2",
         * "25",
         * "4",
         * "",
         * "182",
         * "29",
         * "8",
         * "8",
         * "29",
         * "182",
         * "2"]
         */
        String[] result = db.parse(queries);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
