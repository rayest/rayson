package mobi.rayson.sourcecode.spring.beaninitdestroy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Spiderman implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        log.info("销毁");
    }
}
