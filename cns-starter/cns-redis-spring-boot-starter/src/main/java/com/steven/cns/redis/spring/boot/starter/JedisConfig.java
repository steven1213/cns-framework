package com.steven.cns.redis.spring.boot.starter;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * @author: steven
 * @date: 2023/7/26 23:33
 */
@Component
@RequiredArgsConstructor
public class JedisConfig {

    private final RedisProperties redisProperties;

    @Bean
    @ConditionalOnProperty(prefix = RedisProperties.REDIS_PREFIX, name = "mode")
    public JedisPool jedisPool() {
        RedisModel mode = redisProperties.getMode();
        switch (mode) {
            case SINGER:
                return JedisPoolBuilder.buildSingle(redisProperties.getSingle());
            case CLUSTER:
                return JedisPoolBuilder.buildCluster(redisProperties.getCluster());
            case SENTINEL:
                return JedisPoolBuilder.buildSentinel(redisProperties.getSentinel());
            case MASTER_SLAVE:
                return JedisPoolBuilder.buildMasterSlave(redisProperties.getMasterSlave());
            default:
                throw new IllegalArgumentException("redis mode is illegal");
        }
    }
}
