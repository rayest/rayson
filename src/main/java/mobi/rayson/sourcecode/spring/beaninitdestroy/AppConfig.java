package mobi.rayson.sourcecode.spring.beaninitdestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("mobi.rayson.sourcecode.spring.beaninitdestroy")
public class AppConfig {

    @Bean(initMethod = "start", destroyMethod = "end")
    public Room room(){
        return new Room();
    }
}
