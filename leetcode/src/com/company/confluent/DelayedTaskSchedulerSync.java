package com.company.confluent;

import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Question:
// The question here is to design a delayed scheduler that can accept a Runnable task with a delay.
// The task should be executed after the delay time.
// Approach:
// The Java program you provided for DelayScheduleMonitor essentially implements a custom task scheduling system using
// a thread pool and a priority queue for time-based scheduling.
// The overall design pattern followed here can be best described as a Producer-Consumer pattern,
// with some elements of the ThreadPool pattern for managing concurrent task execution. Here’s a breakdown of how these patterns are used:
//
//Producer-Consumer Pattern
//In the context of your program:
//
//Producers
//The producers are represented by the code that schedules tasks using the schedule() method.
//These producers add tasks (Runnable objects along with a delay time) to a shared resource, which is the DelayBlockingQueue.
//The task here is not immediately executed but rather put into a queue to be handled at the appropriate time
// based on its scheduled run time (runTime).
//Consumers
//The consumers are the threads created and managed by the ThreadPoolExecutor within the DelayScheduleMonitor class.
//These consumer threads continuously take tasks from the DelayBlockingQueue using the take() method, which includes
// logic to only allow tasks to be taken when they are due to run (i.e., when their delay has elapsed).
//Once a task is taken, it is executed by the same consumer thread on the thread pool.
//ThreadPool Pattern
//The use of ThreadPoolExecutor is a classic implementation of the ThreadPool pattern, where a fixed number of threads are created to execute tasks.
//Tasks are submitted to the pool, and threads in the pool will execute these tasks as soon as they become available.
//This helps in efficiently managing a large number of tasks with a limited number of threads, which reduces the overhead
// associated with thread creation and destruction
public class DelayedTaskSchedulerSync {

    static class Task {
        Runnable runnable;
        long runTime;

        Task(Runnable runnable, long runTime) {
            this.runnable = runnable;
            this.runTime = runTime;
        }
    }

    static class DelayBlockingQueue {
        private final PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> Long.compare(a.runTime, b.runTime));

        //  The method is synchronized to prevent concurrent modifications to the priority queue,
        //  which is not thread-safe by itself.
        synchronized void add(Runnable runnable, long delayTime) {
            long runTime = System.currentTimeMillis() + delayTime;
            Task newTask = new Task(runnable, runTime);
            pq.add(newTask);
            if (pq.peek() == newTask) {
                notifyAll();  // notifyAll wakes up all threads waiting on this object (specifically those blocked in the take method).
            }
        }

        synchronized boolean remove(Runnable runnable) {
            for (Task task : pq) {
                if (task.runnable.equals(runnable)) {
                    pq.remove(task);
                    return true;
                }
            }
            return false;
        }

        // Purpose of while (true) in take() Method
        //  1. Handling Spurious Wakeups
        // Spurious wakeups are wakeups from a wait() state that occur without any corresponding notification via notify() or notifyAll().
        // These are rare, but they can and do happen in Java applications. The while (true) loop ensures that after a thread wakes up, it rechecks the condition it is supposed to be waiting for, rather than assuming the wakeup was legitimate.
        //  2. Ensuring Task Conditions Are Met
        //  Tasks are supposed to execute at or after a specific time (runTime). The while (true) loop allows the system to continuously check if the task at the head of the queue is ready to be executed (i.e., whether the current time is past the task's runTime). If it’s not time yet, the thread is put back to sleep:
        // Efficiency and Safety
        //The use of while (true) in this context is efficient and safe due to several reasons:
        //
        //Controlled Blocking: The use of wait() within the loop controls when the thread is active, blocking it when there is nothing to do and only waking up for legitimate reasons (tasks to process or spurious wakeups).
        //Condition Checks: By rechecking conditions (pq.isEmpty() and runTime vs. currentTime) after each wakeup, the system ensures that it only proceeds when appropriate, thereby preventing errors and inefficiencies.
        //Resource Management: This approach ensures that threads are not consuming CPU resources unnecessarily, which is a critical consideration in server environments or applications where resource efficiency is paramount.
        synchronized Task take() throws InterruptedException {
            while (true) {
                while (pq.isEmpty()) {
                    // This loop checks if the task queue is empty and if so, puts the thread into a wait state until new tasks are added to the queue. It's critical for avoiding errors like trying to access elements in an empty queue, and it also efficiently handles the timing of task availability.
                    System.out.println(Thread.currentThread().getName() + " waiting on empty");
                    wait();
                    // This loop might seem to be a potential point of resource wastage because it continuously checks a condition. However, the inclusion of wait() within this loop mitigates such issues by not allowing the loop to spin freely; instead, the thread is suspended when the queue is empty and only resumes when there might be a task to process (after a notifyAll() call from add()).
                }
                Task task = pq.peek();
                long headTime = task.runTime;
                long currentTime = System.currentTimeMillis();

                if (headTime <= currentTime) {
                    Task taken = pq.poll();
                    return taken;
                } else {
                    long waitTime = headTime - currentTime;
//                    System.out.println(Thread.currentThread().getName() + " waiting " + waitTime + " ms");
                    wait(waitTime);
                }
            }
        }
    }

    public boolean cancel(Runnable runnable) {
        return delayBlockingQueue.remove(runnable);
    }
    private final DelayBlockingQueue delayBlockingQueue = new DelayBlockingQueue();
    private final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    public void schedule(Runnable runnable, int delayTime) {
        delayBlockingQueue.add(runnable, delayTime);
    }

    public void start() {
        for (int i = 0; i < 10; i++) { // Create multiple threads to handle the tasks
            executor.submit(() -> {
                while (true) {
                    // This loop in the start() method ensures that the worker threads created in the thread pool continue to execute tasks indefinitely.
                    // Once a task is completed, the thread will loop back and wait to take the next available task from the queue. This design is typical in server-like applications where the termination condition is not predefined and the service should run continuously until externally stopped.
                    try {
                        Task curTask = delayBlockingQueue.take();
//                        System.out.println("Executing task: " + curTask.toString());
                        curTask.runnable.run();
                    } catch (InterruptedException ex) {
                        System.out.println("Thread was interrupted, will exit.");
                        Thread.currentThread().interrupt();
                        return; // Correct way to handle interruption in Java
                    }

                }
            });
        }
    }


    public static void main(String[] args) {
        DelayedTaskSchedulerSync monitor = new DelayedTaskSchedulerSync();

        Thread monitorThread = new Thread(new Runnable() {
            public void run() {
                monitor.start();
            }
        });
        monitorThread.start();

        monitor.schedule(new Runnable() {
            public void run() {
                System.out.println("Task 1 executed");
            }
        }, 5000);

        monitor.schedule(new Runnable() {
            public void run() {
                System.out.println("Task 2 executed");
            }
        }, 3000);

        monitor.schedule(new Runnable() {
            public void run() {
                System.out.println("Task 3 executed");
            }
        }, 4000);

        try {
            monitorThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted.");
        }
//        monitor.schedule(() -> System.out.println("Task 1 executed"), 5000);
//        monitor.schedule(() -> System.out.println("Task 2 executed"), 3000);
//        monitor.schedule(() -> System.out.println("Task 3 executed"), 4000);
    }
}

