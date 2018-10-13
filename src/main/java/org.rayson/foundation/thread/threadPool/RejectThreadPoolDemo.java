package org.rayson.foundation.thread.threadPool;

import java.util.concurrent.*;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午9:12
 *  Description: 拒绝策略
 **/
public class RejectThreadPoolDemo implements Runnable {

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + ": Thread ID: " + Thread.currentThread().getId());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RejectThreadPoolDemo task = new RejectThreadPoolDemo();
        ExecutorService service = new ThreadPoolExecutor(
                5,
                5,
                0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                (r, executor) -> System.out.println(r.toString() + " is discard"));

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.submit(task);
            Thread.sleep(10);
        }
    }
}
