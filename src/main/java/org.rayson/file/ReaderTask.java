package org.rayson.file;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午6:05
 *  Description:
 **/

public class ReaderTask implements Callable<Map<String, FileInputStream>> {

    private CountDownLatch latch;
    private File file;

    public ReaderTask(CountDownLatch latch, File file) {
        this.latch = latch;
        this.file = file;
    }

    @Override
    public Map<String, FileInputStream> call() throws Exception {
        FileInputStream fis = new FileInputStream(file);
        Map<String, FileInputStream> fileMap = new HashMap<>();
        fileMap.put(file.getName(), fis);
        doWork();
        latch.countDown();
        return fileMap;
    }

    private void doWork() {
        Random rand = new Random();
        int time = rand.nextInt(10) * 1000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

