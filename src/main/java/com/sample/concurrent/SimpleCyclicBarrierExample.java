package com.sample.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class SimpleCyclicBarrierExample {
    private static final int NUMBER_OF_THREADS = 5;
    private static AtomicInteger counter = new AtomicInteger();
    private static CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_THREADS, new Runnable() {
        @Override
        public void run() {
            System.out.println(counter.getAndIncrement());
        }
    });

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        System.out.println("starting cyclicRunners");
        Stream.iterate(0, i-> i<NUMBER_OF_THREADS, i-> i+1).forEach(i -> executors.submit(new CyclicRunner()));
        executors.shutdown();
    }
    static class CyclicRunner extends Thread {

        @Override
        public void run() {
            while(counter.get() <=3){
                System.out.println(this.getName() + " " + counter.get());
                System.out.println(this.getName() + " executing");
                System.out.println(this.getName() + " awaiting");
                try {
                    barrier.await();
                    System.out.println(this.getName() + "finsihed waiting");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
