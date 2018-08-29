package org.rayson.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午6:06
 *  Description:
 **/
public class WriterTask implements Runnable {

    private Logger logger = LoggerFactory.getLogger(WriterTask.class);

    private BlockingQueue<Future<Map<String, FileInputStream>>> queue;
    private CountDownLatch latch;

    public WriterTask(BlockingQueue<Future<Map<String, FileInputStream>>> queue, CountDownLatch latch) {
        this.queue = queue;
        this.latch = latch;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            Future<Map<String, FileInputStream>> future = queue.take();
            Map<String, FileInputStream> map = future.get();
            Set<String> set = map.keySet();
            for (String fileName : set) {
                logger.info("New file name: {}", fileName);
                String filePath = "src/main/resources/file/target/" + fileName;
                bufferedWriter = new BufferedWriter(new FileWriter(new File(filePath)));

                String data;
                FileInputStream fileInputStream = map.get(fileName);
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                logger.info("线程：{} 开始写文件...", Thread.currentThread().getName());
                while ((data = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(data + "\r");
                }
                logger.info("线程：{} 写文件完成...", Thread.currentThread().getName());
                latch.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}