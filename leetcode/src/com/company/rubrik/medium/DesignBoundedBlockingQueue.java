package com.company.rubrik.medium;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class DesignBoundedBlockingQueue {
    private Semaphore enq;
    private Semaphore deq;
    private ConcurrentLinkedDeque<Integer> q;

    public DesignBoundedBlockingQueue(int capacity) {
        enq = new Semaphore(capacity);
        deq = new Semaphore(0);
        q = new ConcurrentLinkedDeque<>();
    }

    public void enqueue(int element) throws InterruptedException {
        enq.acquire();
        q.offer(element);
        deq.release();
    }

    public int dequeue() throws InterruptedException {
        deq.acquire();
        int val = q.poll();
        enq.release();
        return val;
    }

    public int size() {
        return q.size();
    }
}
