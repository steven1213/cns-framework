package com.steven.cns.redis.spring.boot.starter;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: steven
 * @date: 2023/7/27 13:48
 */
@Configuration
@Import({RedissonConfig.class, RedisProperties.class, JedisConfig.class})
public class EnableAutoRedisConfiguration {
}
