package com.company.confluent;

import java.util.*;

// Represents a registered function with its argument types and variadic property
class RegisteredFunction {
    String name;
    List<String> argumentTypes;
    boolean isVariadic;

    public RegisteredFunction(String name, List<String> argumentTypes, boolean isVariadic) {
        this.name = name;
        this.argumentTypes = argumentTypes;
        this.isVariadic = isVariadic;
    }
}
//Time complex:  0(m*n) ...m = number of functions registered,
// n = maximum number of argument types in the input list or any function definition (whichever is larger)
// Space complex:  0(m*n)

// Registry to hold and manage all functions
class FunctionRegistryMap {


    Map<String, List<String>> nonVariadic = new HashMap<>();
    Map<String, List<String>> variadic = new HashMap<>();

    void register(String functionName, List<String> arguments, boolean isVar) {
        String key = appendArgs(arguments, arguments.size());
        if (isVar) {
            variadic.putIfAbsent(key, new LinkedList<>());
            variadic.get(key).add(functionName);
        } else {
            nonVariadic.putIfAbsent(key, new LinkedList<>());
            nonVariadic.get(key).add(functionName);
        }
    }

    public List<String> findMatches(List<String> arguments) {
        List<String> matches = new ArrayList<>();
        String key = appendArgs(arguments, arguments.size());

        if (nonVariadic.containsKey(key)) {
            matches.addAll(nonVariadic.get(key));
        }
        if (variadic.containsKey(key)) {
            matches.addAll(variadic.get(key));
        }

        int count = arguments.size();

        for (int i = arguments.size() - 2; i >= 0; --i) {
            if (arguments.get(i).equals(arguments.get(i + 1))) {
                --count;
            } else {
                break;
            }
            key = appendArgs(arguments, count);
            if (variadic.containsKey(key)) {
                matches.addAll(variadic.get(key));
            }
        }
        return matches;
    }

    String appendArgs(List<String> argumentTypes, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            String arg = argumentTypes.get(i);
            sb.append(arg);
            sb.append("+");
        }
        return sb.toString();
    }


    List<RegisteredFunction> functions = new ArrayList<>();

    public void register2(String name, List<String> argTypes, boolean isVariadic) {
        functions.add(new RegisteredFunction(name, argTypes, isVariadic));
    }


    public List<String> findMatches2(List<String> inputTypes) {
        List<String> matches = new ArrayList<>();
        for (RegisteredFunction func : functions) {
            if (isMatch(func, inputTypes)) {
                matches.add(func.name);
            }
        }
        return matches;
    }

    private boolean isMatch(RegisteredFunction func, List<String> inputTypes) {
        if (!func.isVariadic) {
            return func.argumentTypes.equals(inputTypes);
        } else {
            if (inputTypes.size() < func.argumentTypes.size() - 1) {
                return false; // Not enough arguments
            }
            for (int i = 0; i < func.argumentTypes.size() - 1; i++) {
                if (!func.argumentTypes.get(i).equals(inputTypes.get(i))) {
                    return false;
                }
            }
            String variadicType = func.argumentTypes.get(func.argumentTypes.size() - 1);
            for (int i = func.argumentTypes.size() - 1; i < inputTypes.size(); i++) {
                if (!inputTypes.get(i).equals(variadicType)) {
                    return false;
                }
            }
            return true;
        }
    }
}

public class FunctionMatcher {
    public static void main(String[] args) {
        FunctionRegistryMap registry = new FunctionRegistryMap();
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
}
