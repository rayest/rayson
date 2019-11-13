package mobi.rayson.sourcecode.spring.circulardependency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class StudentA {

    @Autowired
    private StudentB studentB;

    public StudentA() {
        log.info("studentB: {}", studentB);
    }

}
