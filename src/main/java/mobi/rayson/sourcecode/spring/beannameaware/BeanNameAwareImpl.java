package mobi.rayson.sourcecode.spring.beannameaware;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class BeanNameAwareImpl implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        log.info("bean name: " + name);
    }
}


