package mobi.rayson.sourcecode.spring.circulardependency;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDependencyTest {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("studentA"));

    }
}
