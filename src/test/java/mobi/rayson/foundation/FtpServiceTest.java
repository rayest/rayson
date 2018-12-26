package mobi.rayson.foundation;

import mobi.rayson.api.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-11
 *  Time: 下午4:58
 *  Description:
 **/

public class FtpServiceTest extends TestBase {

    @Resource
    private FtpService ftpService;

    @Test
    public void testGetPropertiesFromYaml() {
        FtpProperty.Rayest rayest = ftpService.getRayest();
        assertEquals("lee", rayest.getUsername());
    }
}
