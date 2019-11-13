package mobi.rayson.sourcecode.spring.beanpostprocessor;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    @Test
    public void testGetBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person student = (Person) context.getBean("person");
        Assert.assertNotNull(student);
        Assert.assertEquals("ray", student.getName());
    }
}
