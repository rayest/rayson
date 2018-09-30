package org.rayson.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-30
 *  Time: 下午2:18
 *  Description:
 **/
public class ReentrantLockDemo implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(ReentrantLockDemo.class);

    private static ReentrantLock lock = new ReentrantLock();
    private static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        Thread t1 = new Thread(reentrantLockDemo);
        Thread t2 = new Thread(reentrantLockDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        logger.info("i: {}", i);
    }
}
