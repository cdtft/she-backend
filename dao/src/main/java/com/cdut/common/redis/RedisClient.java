package com.cdut.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by king on 2017/9/12.
 */
@Component
public class RedisClient {

    @Autowired
    private JedisPool jedisPool;

    public void set(byte[] key, byte[] value) throws Exception {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } finally {
            jedis.close();
        }
    }

    public byte[] get(String key) throws Exception {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key.getBytes());
        } finally {
            jedis.close();
        }
    }

    public void hset(String key, String field, String value) throws Exception {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(key, field, value);

        } finally {
            jedis.close();
        }
    }
}
