package com.sample.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadExecutor {
    private static volatile boolean workDone = false;

    public static void main(String[] args) {
        Queue workQueue = new LinkedList();
        Producer producer = new Producer(workQueue);
        List<Consumer> consumers = List.of(new Consumer(workQueue), new Consumer(workQueue), new Consumer(workQueue), new Consumer(workQueue));
        ExecutorService executors = Executors.newFixedThreadPool(6);
        System.out.println("initializing epoch of producer and consumers");
        consumers.parallelStream().forEach(consumer -> executors.submit(consumer));
        executors.submit(producer);
        executors.shutdown();
    }

    static class Producer implements Runnable {

        private final Queue workQueue;

        Producer(Queue workQueue) {
            this.workQueue = workQueue;
        }

        @Override
        public void run() {
            for (int totalWork = 50; totalWork > 0; totalWork--) {
                synchronized (workQueue) {
                    workQueue.add(totalWork);
                    workQueue.notifyAll();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (workQueue) {
                workDone = true;
                workQueue.notifyAll();
            }
        }
    }

    static class Consumer extends Thread {
        private final Queue workQueue;

        Consumer(Queue workQueue) {
            this.workQueue = workQueue;
        }

        @Override
        public void run() {
            do {
                synchronized (workQueue) {
                    if (workQueue.isEmpty() && !workDone) {
                        try {
                            workQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(this.getName() + " task completed : " + workQueue.poll());
                    }
                }
            } while (!workDone);
        }
    }
}