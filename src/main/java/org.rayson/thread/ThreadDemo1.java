package org.rayson.thread;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-26
 *  Time: 下午10:16
 *  Description:
 **/
public class ThreadDemo1 implements Runnable{

    @Override
    public void run() {
        System.out.println("demo1");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo1());
        thread.start();
    }


}
