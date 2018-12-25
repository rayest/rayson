package mobi.rayson.foundation.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-12-25
 *  Time: 3:16 PM
 *  Description:
 **/
@Component
@Slf4j
public class SchedulerTask {

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    log.info("现在时间：{}", dateFormat.format(new Date()));
  }

  @Scheduled(cron = "*/5 * * * * *")
  public void anotherCurrentTime() {
    log.info("cron 表达式。现在时间：{}", dateFormat.format(new Date()));
  }
}
