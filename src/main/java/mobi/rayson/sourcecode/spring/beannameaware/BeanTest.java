package mobi.rayson.sourcecode.spring.beannameaware;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    @Test
    public void testGetBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BeanNameAwareImpl beanNameAwareImpl = (BeanNameAwareImpl) context.getBean("beanNameAwareImpl");
        Assert.assertNotNull(beanNameAwareImpl);
    }
}
