package com.steven.cns.redis.spring.boot.starter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: steven
 * @date: 2023/7/26 23:33
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RedissonConfig {

    private final RedisProperties redisProperties;

    @Bean
    @ConditionalOnProperty(prefix = RedisProperties.REDIS_PREFIX, name = "mode")
    public RedissonClient redissonClient() {
        RedisModel mode = redisProperties.getMode();
        switch (mode) {
            case SINGER:
                return RedissonClientBuilder.buildSingle(redisProperties);
            case CLUSTER:
                return RedissonClientBuilder.buildCluster(redisProperties);
            case SENTINEL:
                return RedissonClientBuilder.buildSentinel(redisProperties);
            case MASTER_SLAVE:
                return RedissonClientBuilder.buildMasterSlave(redisProperties);
            default:
                throw new IllegalArgumentException("redis mode is illegal");
        }
    }
}
