package mobi.rayson.foundation.async;

import java.util.concurrent.Future;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-12-25
 *  Time: 3:48 PM
 *  Description:
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceTest {

  @Resource
  private AsyncService asyncService;

  @Test
  public void testAsync() throws Exception {
    long start = System.currentTimeMillis();

    Future<String> task1 = asyncService.doTaskOne();
    Future<String> task2 = asyncService.doTaskTwo();
    Future<String> task3 = asyncService.doTaskThree();
    while (true) {
      if (task1.isDone() && task2.isDone() && task3.isDone()) {
        // 三个任务都调用完成，退出循环等待
        break;
      }
      Thread.sleep(1000);
    }
    long end = System.currentTimeMillis();
    System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
  }
}
