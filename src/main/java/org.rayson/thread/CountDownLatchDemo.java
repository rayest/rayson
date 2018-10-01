package org.rayson.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午2:03
 *  Description: 倒计时器。计数数量为 10，表示需要有 10 个线程完成任务。当一个线程完成任务时，执行 countDown(), 倒计时器减一
 *  await() 方法要求主线程等待所有的 10 个检查任务全部完成
 **/
public class CountDownLatchDemo implements Runnable {

    private static CountDownLatch latch = new CountDownLatch(10);

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000); // 模拟检查任务
            System.out.println("Check completed.");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(demo);
        }
        latch.await();
        System.out.println("Fire!");
        executorService.shutdown();
    }
}
