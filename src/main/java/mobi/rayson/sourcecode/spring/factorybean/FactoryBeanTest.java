package mobi.rayson.sourcecode.spring.factorybean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTest {

    @Test
    public void testGetBeanFromFactoryBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DogFactoryBean bean = (DogFactoryBean) context.getBean("dogFactoryBean");
        Assert.assertEquals("lee", bean.getDog());
    }
}
