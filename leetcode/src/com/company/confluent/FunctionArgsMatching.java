package com.company.confluent;

import java.util.*;

//https://leetcode.com/discuss/interview-question/759611/Confluent-or-Senior-Software-Engineer-or-Phone-interview
// O(N) for each function where N is the number of arguments in the function, since it iterates over each argument.
// Time: Insertion, Matching: o(N)
// Space: O(D * K) where D is the depth of the Trie (maximum number of arguments in any function)
// and K is the average number of children per Trie node.
public class FunctionArgsMatching {
    Trie root = new Trie();

    public static void main(String[] args) {



        FunctionArgsMatching registry = new FunctionArgsMatching();
        registry.register("FuncA", Arrays.asList("String", "Integer", "Integer"), false);
        registry.register("FuncB", Arrays.asList("String", "Integer"), true);
        registry.register("FuncC", Arrays.asList("Integer"), true);
        registry.register("FuncD", Arrays.asList("Integer", "Integer"), true);
        registry.register("FuncE", Arrays.asList("Integer", "Integer", "Integer"), false);
        registry.register("FuncF", Arrays.asList("String"), false);
        registry.register("FuncG", Arrays.asList("Integer"), false);

        System.out.println(registry.findMatches(Arrays.asList("String"))); // Output: [FuncF]
        System.out.println(registry.findMatches(Arrays.asList("Integer"))); // Output: [FuncC, FuncG]
        System.out.println(registry.findMatches(Arrays.asList("Integer", "Integer", "Integer", "Integer"))); // Output: [FuncC, FuncD]
        System.out.println(registry.findMatches(Arrays.asList("Integer", "Integer", "Integer"))); // Output: [FuncC, FuncD, FuncE]
        System.out.println(registry.findMatches(Arrays.asList("String", "Integer", "Integer", "Integer"))); // Output: [FuncB]
        System.out.println(registry.findMatches(Arrays.asList("String", "Integer", "Integer"))); // Output: [FuncA, FuncB]
    }

    List<String> findMatches(List<String> args) {
        Trie curr = root;
        List<String> res = new ArrayList<>();
        int size = args.size();
        for (int i = 0; i < args.size(); i++) {
            String arg = args.get(i);
            if (!curr.children.containsKey(arg)) return res;
            else {
                if (i != size - 1 &&  curr.children.get(arg).varTrueList.size() >0) {
                    if (isSame(args, i, arg))
                        res.addAll( curr.children.get(arg).varTrueList);
                }
                if (i == size - 1) {
                    if (curr.children.get(arg).varTrueList.size() > 0)
                        res.addAll(curr.children.get(arg).varTrueList);
                    if (curr.children.get(arg).varFalseList.size() > 0)
                        res.addAll(curr.children.get(arg).varFalseList);
                }
                curr = curr.children.get(arg);
            }
        }
        return res;
    }

    boolean isSame(List<String> args, int idx, String arg) {
        for (int i = idx; i < args.size(); i++) {
            if (args.get(i) != arg) return false;
        }
        return true;
    }



    void register(String functionName, List<String> arguments, boolean isVar) {
        Trie curr = root;
        for (int i = 0; i < arguments.size(); i++) {
            String argument = arguments.get(i);
            if (!curr.children.containsKey(argument)) {
                curr.children.put(argument, new Trie());
            }

            // follow yp:1 If getFunction(string,integer...)
//            if (isVar && i == arguments.size() - 1) {
//                // Mark the current node as also valid endpoint for the function
//                curr.varTrueList.add(functionName);
//            }
            curr = curr.children.get(argument);
        }
        if (isVar) curr.varTrueList.add(functionName);
        else curr.varFalseList.add(functionName);
    }


    // follow up 2: If getfunction(string,Null), null can represent all possibilities
    List<String> match2(List<String> args) {
        Trie curr = root;
        List<String> res = new ArrayList<>();
        int size = args.size();
        for (int i = 0; i < size; i++) {
            String arg = args.get(i);

            if (curr.children.containsKey("Null")) {
                // If 'Null' is a child, it can potentially match any type
                res.addAll(curr.children.get("Null").varTrueList); // Considering varTrueList for simplicity
            }

            if (!curr.children.containsKey(arg)) {
                if (!curr.children.containsKey("Null")) {
                    break; // No match and no wildcard
                } else {
                    curr = curr.children.get("Null");
                    continue;
                }
            }

            curr = curr.children.get(arg);
            if (i == size - 1) {
                res.addAll(curr.varTrueList);
                res.addAll(curr.varFalseList);
            }
        }
        return res;
    }

//    follow up 3: Achieve the first two follow up at the same time
    List<String> match3(List<String> args) {
        Trie curr = root;
        List<String> res = new ArrayList<>();
        int size = args.size();
        for (int i = 0; i < size; i++) {
            String arg = args.get(i);

            if (curr.children.containsKey("Null")) {
                // If 'Null' is a child, it can potentially match any type
                res.addAll(curr.children.get("Null").varTrueList); // Considering varTrueList for simplicity
                if (isSame(args, i, arg)) {
                    res.addAll(curr.children.get("Null").varTrueList);
                }
            }

            if (!curr.children.containsKey(arg)) {
                if (!curr.children.containsKey("Null")) {
                    break; // No match and no wildcard
                } else {
                    curr = curr.children.get("Null");
                    continue;
                }
            }

            curr = curr.children.get(arg);
            if (i == size - 1 || isSame(args, i+1, arg)) {
                res.addAll(curr.varTrueList);
            }
            if (i == size - 1) {
                res.addAll(curr.varFalseList);
            }
        }
        return res;
    }

}


class Trie {
    Map<String, Trie> children = new HashMap<>();
    List<String> varTrueList = new ArrayList<>();
    List<String> varFalseList = new ArrayList<>();
}

// Suppose you are building a library and have following definition of a function and two methods register and findMatches.
//Register method registers a function and its argumentTypes in the library and
// findMatches accepts an input argument list and tries to find all the functions that match this input argument list.
// If a function is marked as isVariadic=true, then the last argument can occur one or more number of times.
//
//Example:
//FuncA: [String, Integer, Integer]; isVariadic = false
//FuncB: [String, Integer]; isVariadic = true
//FuncC: [Integer]; isVariadic = true
//FuncD: [Integer, Integer]; isVariadic = true
//FuncE: [Integer, Integer, Integer]; isVariadic = false
//FuncF: [String]; isVariadic = false
//FuncG: [Integer]; isVariadic = false
//
//findMatches({String}) -> [FuncF]
//findMatches({Integer}) -> [FuncC, FuncG]
//findMatches({Integer, Integer, Integer, Integer}) -> [FuncC, FuncD]
//findMatches({Integer, Integer, Integer}) -> [FuncC, FuncD, FuncE]
//findMatches({String, Integer, Integer, Integer}) -> [FuncB]
//findMatches({String, Integer, Integer}) -> [FuncA, FuncB]

//follow up 1: If getFunction(string,integer...) How to deal with this?
//It means that the last argument can have 0 to n.
//follow up 2: If getfunction(string,Null), null can represent all possibilities
// follow up 3: Achieve the first two follow up at the same time