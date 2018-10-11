package org.rayson.foundation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-11
 *  Time: 下午4:52
 *  Description:
 **/
@Data
@Component
@ConfigurationProperties(prefix = "ftp")
public class FtpProperty {

    public Rayest rayest;

    @Data
    public static class Rayest {
        private int port;
        private String hostname;
        private String username;
        private String password;
    }
}
