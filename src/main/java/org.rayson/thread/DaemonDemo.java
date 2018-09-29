package org.rayson.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-28
 *  Time: 下午2:28
 *  Description:
 **/
public class DaemonDemo implements Runnable {

    private Logger logger = LoggerFactory.getLogger(DaemonDemo.class);

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is working...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonDemo(), "T-1");
        thread.setDaemon(true);
        thread.start();

        // T-1 线程在主线程等待2秒后停止打印
        Thread.sleep(2000);
    }
}
