package mobi.rayson.sourcecode.spring.circulardependency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class StudentB {

    @Autowired
    private StudentC studentC ;

    public StudentB() {
        log.info("studentC: {}", studentC);
    }

}
