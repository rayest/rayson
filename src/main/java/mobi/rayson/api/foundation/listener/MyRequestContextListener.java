package mobi.rayson.api.foundation.listener;

import javax.servlet.annotation.WebListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-12-25
 *  Time: 4:49 PM
 *  Description:
 **/
@Configuration
@WebListener
public class MyRequestContextListener extends RequestContextListener {

}