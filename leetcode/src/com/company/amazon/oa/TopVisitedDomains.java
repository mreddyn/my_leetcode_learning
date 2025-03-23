package com.company.amazon.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopVisitedDomains {
    private List<String> getTopVisitedDomains(List<String> domains, int k) {
        if (domains == null || domains.size() == 0) {
            return null;
        }

        var map = new HashMap<String, Integer>();
        for (var domain : domains) {
            int n = domain.length();
            for (int i = 0; i < n; i++) {
                if (domain.charAt(i) == '.') {
                    var sub_domain = domain.substring(i + 1);
                    map.put(sub_domain, map.getOrDefault(sub_domain, 0) + 1);
                }
            }

            // finally put the domain itself
            map.put(domain, map.getOrDefault(domain, 0) + 1);
        }

        System.out.println(map);
        var min_heap = new PriorityQueue<DomainVisit>((a, b) -> (a.count - b.count));
        for (var entry : map.entrySet()) {
            min_heap.offer(new DomainVisit(entry.getKey(), entry.getValue()));
            if (min_heap.size() > k) {
                min_heap.poll();
            }
        }

        var result = new ArrayList<String>();
        while (!min_heap.isEmpty()) {
            result.add(min_heap.poll().domain);
        }

        return result;
    }

    record DomainVisit(String domain, int count) {
    };

    public static void main(String[] args) {
        var instance = new TopVisitedDomains();
        List<String> domains = List.of("news.apple.cn", "news.apple.com", "ipod.apple.com", "hello.hi.apple.com",
                "finance.yahoo.com", "tea.yahoo.com", "finance.yahooooo.com", "hello.google.com", "news.google.com",
                "ai.google.com");
        int k = 3;
        System.out.println(instance.getTopVisitedDomains(domains, k)); // Expected output: [mail.com, google.mail.com,
                                                                       // intel.mail.com]
    }
}
