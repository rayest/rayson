package org.rayson.foundation.thread;

import java.util.concurrent.locks.ReentrantLock;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-30
 *  Time: 下午4:33
 *  Description: 产生死锁，但是使用了锁中断，解决了死锁
 *  lock = 1 的线程会先获取 lock1 锁
 *  lock = 2 的线程会先获取 lock2 锁
 *  Thread.sleep(500) 的设置是为了使两个线程先获得彼此不同的一个锁
 *  此时，锁 lock1 和 lock2 都分别被两个线程拥有，从而导致接下来的锁获取失败，即死锁
 *  又由于这里锁的获取是采用 lockInterruptibly() 方式获取的，所以死锁可以响应中断  t2.interrupt();
 *  最终，只有线程 t1 执行成功
 **/
public class ReentrantLockInterruptDemo implements Runnable {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    // 控制加锁顺序，方便构造死锁
    public ReentrantLockInterruptDemo(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + ": 线程退出");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockInterruptDemo demo1 = new ReentrantLockInterruptDemo(1);
        ReentrantLockInterruptDemo demo2 = new ReentrantLockInterruptDemo(2);
        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }
}
