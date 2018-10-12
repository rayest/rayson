package org.rayson.foundation;

import org.junit.Test;
import org.rayson.foundation.FtpProperty;
import org.rayson.foundation.FtpService;
import org.rayson.integration.TestBase;

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
