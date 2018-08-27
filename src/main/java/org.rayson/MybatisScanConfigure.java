package org.rayson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"org.rayson"})
public class MybatisScanConfigure {
}
