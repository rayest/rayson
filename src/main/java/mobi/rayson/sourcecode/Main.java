package mobi.rayson.sourcecode;

import mobi.rayson.sourcecode.spring.beanfactorypostprocessor.AppConfig;
import mobi.rayson.sourcecode.spring.beanfactorypostprocessor.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }
}
