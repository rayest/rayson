package mobi.rayson.sourcecode.spring.context;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

    @Test
    public void testApplicationContext() {
        // ApplicationContext 继承于 BeanFactory
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ContextDemo contextDemo = (ContextDemo) context.getBean("contextDemo");
        Assert.assertEquals("lee", contextDemo.getName());
    }

    @Test
    public void testBeanFactory() {
        BeanFactory context = new AnnotationConfigApplicationContext(AppConfig.class);
        ContextDemo contextDemo = (ContextDemo) context.getBean("contextDemo");
        Assert.assertEquals("lee", contextDemo.getName());
    }
}
