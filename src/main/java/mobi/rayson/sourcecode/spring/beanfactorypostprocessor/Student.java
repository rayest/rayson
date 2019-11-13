package mobi.rayson.sourcecode.spring.beanfactorypostprocessor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Component
@Slf4j
public class Student {
    private String name = "init";
}
