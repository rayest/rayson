package mobi.rayson.api.foundation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class CommmonConfiguration {
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println("事务处理器：" + platformTransactionManager.getClass().getName());
        return new Object();
    }
}
