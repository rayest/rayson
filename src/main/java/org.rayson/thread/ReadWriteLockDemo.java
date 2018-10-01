package org.rayson.thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午1:40
 *  Description:
 **/
public class ReadWriteLockDemo {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000); // 模拟读操作
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000); // 模拟写操作
            value = index;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = () -> {
            try {
                demo.handleRead(readLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable writeRunnable = () -> {
            try {
                demo.handleWrite(writeLock, new Random().nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 18; i < 20; i++) {
            new Thread(writeRunnable).start();
        }

    }
}
