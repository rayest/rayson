package mobi.rayson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-07-31
 *  Time: 下午2:26
 *  Description:
 **/
@MapperScan(basePackages = {"mobi.rayson"})
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class RaysonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RaysonApplication.class, args);
    }
}
