package mobi.rayson.sourcecode.spring.beaninitdestroy;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    @Test
    public void testDestroyBeanByInitAndDestroyBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Room room = (Room) context.getBean("room");
        Assert.assertNotNull(room);
        room.use();
        context.close();
    }

    @Test
    public void testDestroyBeanByDisposableBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // context.close()将关闭该应用程序的上下文，释放所有资源，并销毁所有缓存的单例bean
        context.close();
    }
}
