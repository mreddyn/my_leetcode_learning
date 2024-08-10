package com.oa.company.microsoft;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServiceStartupOrder {
    private Map<String, List<String>> adjacencyList = new HashMap<>();
    private Set<String> services = new HashSet<>();

    private List<String> findStartupOrder() {
        System.out.println(adjacencyList);
        List<String> startupOrderList = new ArrayList<>();
        Map<String, Integer> inDegree = new HashMap<>();

        ArrayDeque<String> queue = new ArrayDeque<>(); 
        
        // initially inDegree will be zero for all services
        for(String service : services) {
            int size = adjacencyList.get(service).size();
            inDegree.put(service, size);
        }
        System.out.println(inDegree);
        // find service which have no dependencies, that is zero inDegree
        for(String service : inDegree.keySet()) {
            int degree = inDegree.get(service);
            if(degree == 0) {
                queue.add(service);
            }
        }

        while(!queue.isEmpty()) {
            String currentService = queue.poll();
            startupOrderList.add(currentService);
            adjacencyList.remove(currentService);

            // now go the list and remove the outDegree connections of this service and decrease the inDegree
            for(String key : adjacencyList.keySet()) {
                for(String dependencyService : adjacencyList.get(key)) {
                    if(dependencyService.equals(currentService)) {
                        int degree = inDegree.get(key);
                        degree--;
                        if(degree > 0) {
                            inDegree.put(key, degree);
                        }
                        if(degree == 0) {
                            queue.add(key);
                        }
                        break;
                    }
                }
            }

        }
        System.out.println(startupOrderList);
        return startupOrderList;
    }

    private void addDependencies(String service, List<String> dependencies) {
        services.add(service);
        dependencies.forEach(dep -> services.add(dep));
        adjacencyList.putIfAbsent(service, new ArrayList<>());
        adjacencyList.get(service).addAll(dependencies);
    }
    

    public static void main(String[] args) {
        ServiceStartupOrder startupOrder = new ServiceStartupOrder();
        startupOrder.addDependencies("A", Arrays.asList("B", "C", "D", "E"));
        startupOrder.addDependencies("B", Arrays.asList("C", "E", "F"));
        startupOrder.addDependencies("C", new ArrayList<>());
        startupOrder.addDependencies("D", Arrays.asList("F", "G"));
        startupOrder.addDependencies("E", Arrays.asList("G"));
        startupOrder.addDependencies("F", Arrays.asList("E"));
        startupOrder.addDependencies("G", new ArrayList<>());
        startupOrder.addDependencies("H", Arrays.asList("A"));

        List<String> order = startupOrder.findStartupOrder();
        if (order == null) {
            System.out.println("There is a cyclic dependency, no valid startup order is possible.");
        } else {
            System.out.println("Valid startup order: " + order);
        }

    }
}
