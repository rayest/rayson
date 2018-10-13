package org.rayson.foundation.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-02
 *  Time: 下午4:40
 *  Description: AtomicInteger 内部使用了 CAS：compareAndSwap
 **/
public class AtomicIntegerDemo implements Runnable {
    private static AtomicInteger i = new AtomicInteger();

    @Override
    public void run() {
        for (int k = 0; k < 10000000; k++) {
            i.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int j = 0; j < 10; j++) {
            threads[j] = new Thread(new AtomicIntegerDemo());
        }
        for (int j = 0; j < 10; j++) {
            threads[j].start();
        }

        for (int j = 0; j < 10; j++) {
            threads[j].join();
        }

        System.out.println(i);
    }
}
