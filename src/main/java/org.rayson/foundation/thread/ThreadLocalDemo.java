package org.rayson.foundation.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-02
 *  Time: 下午3:30
 *  Description: ThreadLocal。将每个不安全的对象放到该 ThreadLocal 容器中
 **/
public class ThreadLocalDemo implements Runnable {
    private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<>();
    int i;

    public ThreadLocalDemo(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            if (dateFormatThreadLocal.get() == null) {
                dateFormatThreadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
            Date date = dateFormatThreadLocal.get().parse("2015-03-29 19:29:" + 1 % 60);
            System.out.println(i + " : " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            service.execute(new ThreadLocalDemo(i));
        }
    }
}
