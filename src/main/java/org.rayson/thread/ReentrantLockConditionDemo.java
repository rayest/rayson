package org.rayson.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午12:49
 *  Description: 可重入锁与 Condition 接口
 **/
public class ReentrantLockConditionDemo implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("t1 is working...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockConditionDemo demo = new ReentrantLockConditionDemo();
        Thread t1 = new Thread(demo);
        t1.start();
        Thread.sleep(2000);
        // 通知 t1 继续执行
        lock.lock();
        condition.signal();
        lock.unlock();
    }


}
