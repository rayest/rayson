package org.rayson.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午1:12
 *  Description: 信号量。申明了一个包含 5 个许可的信号量，即允许 5 个线程同时访问一个临界资源
 *  20 个线程被分为 4 组，每组 5 个进行资源访问，都访问结束后，释放信号量，重新申请
 **/
public class SemaphoreDemo implements Runnable {

    private final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getId() + ": 访问临界资源...");
            Thread.sleep(2000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            executorService.execute(demo);
        }
    }


}
