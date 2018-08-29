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
public class FileHandler {

    private final static Logger logger = LoggerFactory.getLogger(FileHandler.class);

    public void doTask() {
        File f = new File("src/main/resources/file/source");
        File[] filePaths = f.listFiles();
        final List<File> filePathsList = new ArrayList<>(Arrays.asList(filePaths));
        CountDownLatch latch = new CountDownLatch(8);
        ExecutorService pool = Executors.newFixedThreadPool(8);
        BlockingQueue<Future<Map<String, FileInputStream>>> queue = new ArrayBlockingQueue<>(100);

        logger.info("分配子线程处理文件");
        for (File file : filePathsList) {
            Future<Map<String, FileInputStream>> future = pool.submit(new ReaderTask(latch, file));
            queue.add(future);
            pool.execute(new WriterTask(queue, latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("latch: {}", latch.getCount());
        logger.info("子线程处理完毕...");
        logger.info("main 线程继续处理...");
        pool.shutdownNow();
    }

}