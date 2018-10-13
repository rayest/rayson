package org.rayson.foundation.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午12:00
 *  Description: 锁申请等待限时。每个线程都会在5秒内获取锁，如果获取不到则请求锁失败
 *  在其中一个线程获取锁成功后，并占有该锁6秒，使得另一个线程无法在5秒内获得锁
 *  tryLock() 无参数时，不管能否获得锁，都立即返回 true 或者 false
 **/
public class ReentrantLockTimeDemo implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            } else {
                System.out.println("Get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockTimeDemo demo = new ReentrantLockTimeDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
    }
}
