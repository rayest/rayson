package mobi.rayson.sourcecode.spring.beanpostprocessor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Data
@Component
@Slf4j
public class Person implements InitializingBean {
    private String name = "init";

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("在 bean factory 设置好所有的属性后处理");
        this.name = "ray";
    }
}
