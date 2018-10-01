package org.rayson.thread.cyclicBarrierDemo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-01
 *  Time: 下午2:58
 *  Description:
 **/
public class Soldier implements Runnable {

    private String name;
    private final CyclicBarrier cyclicBarrier;

    Soldier(CyclicBarrier cyclic, String name) {
        this.cyclicBarrier = cyclic;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await(); // 等待所有士兵到齐
            doWork();
            cyclicBarrier.await(); // 等待所有士兵完成工作
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void doWork() {
        try {
            Thread.sleep(Math.abs(new Random().nextInt() % 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "：任务完成");
    }
}
