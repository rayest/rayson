package mobi.rayson.sourcecode.spring.beanfactoryaware;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    @Test
    public void testGetBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BeanFactoryAwareImpl bean = (BeanFactoryAwareImpl) context.getBean("beanFactoryAwareImpl");
        Assert.assertNotNull(bean);
        Assert.assertTrue(bean.getBeanFactory() instanceof DefaultListableBeanFactory);
    }
}
