package org.rayson.foundation.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-26
 *  Time: 下午10:16
 *  Description:
 **/
public class RunnableDemo implements Runnable{
    private static Logger logger = LoggerFactory.getLogger(RunnableDemo.class);

    @Override
    public void run() {
        System.out.println("实现 Runnable 接口，处理业务逻辑");
    }

    public static void main(String[] args) {
        logger.info("新建线程并启动");
        Thread thread = new Thread(new RunnableDemo());
        thread.start();
    }


}
