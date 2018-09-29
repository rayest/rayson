package org.rayson.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-28
 *  Time: 下午2:02
 *  Description:
 **/
public class ThreadGroupDemo implements Runnable {

    private Logger logger = LoggerFactory.getLogger(ThreadGroupDemo.class);

    @Override
    public void run() {
        String threadGroupName = Thread.currentThread().getThreadGroup().getName();
        String threadName = Thread.currentThread().getName();
        while (true) {
            logger.info("{}-{} is working...", threadGroupName, threadName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("groupName");
        Thread t1 = new Thread(threadGroup, new ThreadGroupDemo(), "T-1");
        Thread t2 = new Thread(threadGroup, new ThreadGroupDemo(), "T-2");
        t1.start();
        t2.start();
        System.out.println("active count: " + threadGroup.activeCount());
        threadGroup.list();
    }
}
