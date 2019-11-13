package mobi.rayson.sourcecode.spring.beaninitdestroy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Room {
    private void start() {
        log.info("room start 方法，初始化");
    }

    private void end() {
        log.info("room end 方法，销毁");
    }

    void use(){
        log.info("used");
    }
}
