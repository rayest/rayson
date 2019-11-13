package mobi.rayson.sourcecode.spring.beaninitdestroy;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    @Test
    public void testGetBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Room room = (Room) context.getBean("room");
        Assert.assertNotNull(room);
        room.use();
        context.close(); // 关闭
    }
}
