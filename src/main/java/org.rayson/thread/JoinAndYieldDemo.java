package org.rayson.thread;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-27
 *  Time: 下午4:57
 *  Description:
 **/
public class JoinAndYieldDemo {
    public volatile static int i = 0;

    public static class T extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        t.join();
        System.out.println(i);
    }
}
