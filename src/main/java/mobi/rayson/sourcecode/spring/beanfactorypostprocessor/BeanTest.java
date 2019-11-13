package mobi.rayson.sourcecode.spring.beanfactorypostprocessor;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    @Test
    public void testGetBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Student.class);
        Student student = (Student) context.getBean("student");
        Assert.assertNotNull(student);
        Assert.assertEquals("init", student.getName());
    }

    @Test
    public void testCustomBeanFactoryPostProcessor(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = (Student) context.getBean("student");
        Assert.assertNotNull(student);
        Assert.assertEquals("lee", student.getName());
    }
}
