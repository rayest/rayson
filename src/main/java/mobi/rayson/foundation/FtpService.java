package mobi.rayson.foundation;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-11
 *  Time: 下午4:54
 *  Description:
 **/
@Service
public class FtpService {
    @Resource
    private FtpProperty ftpProperty;

    private FtpProperty.Rayest rayest;

    @PostConstruct
    public void init(){
        rayest = ftpProperty.getRayest();
    }

    public FtpProperty.Rayest getRayest() {
        return rayest;
    }
}
