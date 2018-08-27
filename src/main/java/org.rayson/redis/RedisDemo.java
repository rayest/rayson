package org.rayson.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-27
 *  Time: 下午1:45
 *  Description:
 **/
@Service
public class RedisDemo {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public String getFromCache(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public Boolean setIntoCache(String key, String value, long expiration) {
        stringRedisTemplate.opsForValue().set(key, value);
        return stringRedisTemplate.expire(key, expiration, TimeUnit.SECONDS);
    }
}
