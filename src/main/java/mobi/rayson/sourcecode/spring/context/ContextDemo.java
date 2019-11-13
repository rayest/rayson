package mobi.rayson.sourcecode.spring.context;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class ContextDemo {
    private String name = "lee";
}
