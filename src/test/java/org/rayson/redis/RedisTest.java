package org.rayson.redis;

import org.junit.Test;
import org.rayson.BaseTest;

import javax.annotation.Resource;

import static org.junit.Assert.assertNull;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-27
 *  Time: 上午11:49
 *  Description:
 **/
public class RedisTest extends BaseTest {

    @Resource
    private RedisDemo redisDemo;

    @Test
    public void testRedisTemplate() {
        String key = "test:redis:name:lee";
        String value = redisDemo.getFromCache(key);
        assertNull(value);
    }
}
