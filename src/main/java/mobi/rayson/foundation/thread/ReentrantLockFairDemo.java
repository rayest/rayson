package mobi.rayson.foundation.thread;

import java.util.concurrent.locks.ReentrantLock;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午12:32
 *  Description: 公平锁。两个线程会交替获得锁
 **/
public class ReentrantLockFairDemo implements Runnable {

    private static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + ": 获得了锁");
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockFairDemo demo = new ReentrantLockFairDemo();
        Thread t1 = new Thread(demo, "t1");
        Thread t2 = new Thread(demo, "t2");
        t1.start();
        t2.start();
    }
}
