package org.rayson.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午5:55
 *  Description:
 **/
public class CallableDemo3 {

    public final static Logger logger = LoggerFactory.getLogger(CallableDemo3.class);

    public static void main(String[] args) {
        File f = new File("src/main/resources/file/source");
        File[] filePaths = f.listFiles();
        final List<File> filePathsList = new ArrayList<>(Arrays.asList(filePaths));
        logger.info("file size: {}", filePathsList.size());

        CountDownLatch latch = new CountDownLatch(filePathsList.size());
        ExecutorService pool = Executors.newFixedThreadPool(10);


        BlockingQueue<Future<Map<String, FileInputStream>>> queue = new ArrayBlockingQueue<>(100);

        for (File file : filePathsList) {
            Future<Map<String, FileInputStream>> future = pool.submit(new ReaderTask(latch, file));
            queue.add(future);

            pool.execute(new WriterTask(queue));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.shutdownNow();
    }

}