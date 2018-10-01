package org.rayson.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午8:13
 *  Description: 线程池。内有5个线程，向其中提交了10个任务，线程池安排调度这些任务，分两批执行
 **/
public class ThreadPoolDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolDemo task = new ThreadPoolDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
    }
}
