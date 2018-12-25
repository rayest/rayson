package org.rayson.foundation.async;

import java.util.Random;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-12-25
 *  Time: 3:44 PM
 *  Description:
 **/
@Service
@Slf4j
public class AsyncService {

  private static Random random =new Random();

  @Async
  public Future<String> doTaskOne() throws Exception {
    log.info("开始做任务 1...");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    log.info("完成任务 1，耗时：" + (end - start) + "毫秒");
    return new AsyncResult<>("任务 1 完成");
  }

  @Async
  public Future<String> doTaskTwo() throws Exception {
    log.info("开始做任务 2...");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    log.info("完成任务 2，耗时：" + (end - start) + "毫秒");
    return new AsyncResult<>("任务 2 完成");
  }

  @Async
  public Future<String> doTaskThree() throws Exception {
    log.info("开始做任务 3...");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    log.info("完成任务 3，耗时：" + (end - start) + "毫秒");
    return new AsyncResult<>("任务 3 完成");
  }
}
