package org.rayson.foundation.thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-27
 *  Time: 下午4:14
 *  Description:
 **/
public class WaitAndNotifyDemo {

    private static Logger logger = LoggerFactory.getLogger(WaitAndNotifyDemo.class);
    final static Object object = new Object();

    public static class T1 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": T-1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ": T-1 wait for object");
                    object.wait();
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }
            System.out.println(System.currentTimeMillis() + ": T-1 end!");
        }

    }

    public static class T2 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": T-2 start to notify T-1 !");
                object.notify();
                System.out.println(System.currentTimeMillis() + ": T-2 wait for object");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }
            System.out.println(System.currentTimeMillis() + ": T-2 end!");
        }

    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        t1.start();
        t2.start();
    }
}
