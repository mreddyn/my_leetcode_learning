package com.company.rubrik.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

public class WebCrawlerMultithreaded {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostName(startUrl);

        var res = new ArrayList<String>();
        var visited = new HashSet<String>();
        var queue = new LinkedBlockingDeque<String>();
        var tasks = new ArrayDeque<Future>();

        queue.offer(startUrl);

        // create a thread pool of four threads for I/O operation
        ExecutorService executor = Executors.newFixedThreadPool(4, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

        while (true) {
            String url = queue.poll();
            if (url != null) {
                if (getHostName(url).equals(hostname) && !visited.contains(url)) {
                    res.add(url);
                    visited.add(url);
                    // use a thread to fetch urls and add them to queue
                    tasks.add(executor.submit(() -> {
                        var newUrls = htmlParser.getUrls(url);
                        for (String newUrl : newUrls) {
                            queue.offer(newUrl);
                        }
                    }));
                }
            } else {
                if (!tasks.isEmpty()) {
                    // wait for next task
                    Future nextTask = tasks.poll();
                    try {
                        nextTask.get();
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println(e);
                    }
                } else {
                    // Exit, as all tasks are done
                    break;
                }
            }
        }
        return res;
    }

    private String getHostName(String url) {
        url = url.substring(7);
        String[] parts = url.split("/");
        return parts[0];
    }

    interface HtmlParser {
        public List<String> getUrls(String url);
    }
}
