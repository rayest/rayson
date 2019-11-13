package mobi.rayson.sourcecode.spring.circulardependency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StudentC {

    @Autowired
    private StudentA studentA ;

    public StudentC() {
        log.info("studentA: {}", studentA);
    }

}
