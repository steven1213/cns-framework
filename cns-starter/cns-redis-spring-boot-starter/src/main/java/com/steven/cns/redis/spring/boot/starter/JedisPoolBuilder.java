package com.steven.cns.redis.spring.boot.starter;

import redis.clients.jedis.JedisPool;

/**
 * @author: steven
 * @date: 2023/7/26 23:43
 */
public class JedisPoolBuilder {

    public static JedisPool buildSingle(RedisProperties.SingleModel single) {
        JedisPool pool = new JedisPool();
        return pool;
    }

    public static JedisPool buildCluster(RedisProperties.ClusterModel cluster) {
        JedisPool pool = new JedisPool();
        return pool;
    }

    public static JedisPool buildSentinel(RedisProperties.SentinelModel sentinel) {
        JedisPool pool = new JedisPool();
        return pool;
    }

    public static JedisPool buildMasterSlave(RedisProperties.MasterSlaveModel masterSlave) {
        JedisPool pool = new JedisPool();
        return pool;
    }
}
