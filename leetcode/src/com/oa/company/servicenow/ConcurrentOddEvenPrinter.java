package com.oa.company.servicenow;

public class ConcurrentOddEvenPrinter {
    private final int[] numbers;
    private int index = 0;
    private final Object lock = new Object();

    public ConcurrentOddEvenPrinter(int[] numbers) {
        this.numbers = numbers;
    }

    public void printOddNumbers() {
        synchronized (lock) {
            while (index < numbers.length) {
                if (numbers[index] % 2 != 0) {
                    System.out.println("Odd : " + numbers[index]);
                    index++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Odd Thread Interrupted");
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void printEvenNumbers() {
        synchronized (lock) {
            while (index < numbers.length) {
                if (numbers[index] % 2 == 0) {
                    System.out.println("Even : " + numbers[index]);
                    index++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Even Thread Interrupted");
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ConcurrentOddEvenPrinter cOddEvenPrinter = new ConcurrentOddEvenPrinter(numbers);
        Thread oddNumberThread = new Thread(cOddEvenPrinter::printOddNumbers);
        Thread evenNumberThread = new Thread(cOddEvenPrinter::printEvenNumbers);
        oddNumberThread.start();
        evenNumberThread.start();
    }
}
