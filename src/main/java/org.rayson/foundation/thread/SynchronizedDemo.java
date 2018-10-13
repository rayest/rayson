package org.rayson.foundation.thread;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-28
 *  Time: 下午5:45
 *  Description:
 **/
public class SynchronizedDemo implements Runnable{
    static SynchronizedDemo demo = new SynchronizedDemo();
    static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000000; j++) {
            increase();
        }
    }

    private synchronized void increase() {
        System.out.println(Thread.currentThread().getName() + " is working...");
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(demo, "t1");
        Thread t2 = new Thread(demo, "t2");
        t1.start();
        t2.start();
        // 两个线程都加入执行，但是没有先后执行顺序
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
