package com.steven.cns.common.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: steven
 * @date: 2023/7/26 23:19
 */
@Data
@Component
@ConfigurationProperties(prefix = CnsSpringRedisProperties.REDIS_PREFIX)
public class CnsSpringRedisProperties {
    public static final String REDIS_PREFIX = "cns.spring.redis";

    private RedisModel mode;

    private SingleModel single;

    private MasterSlaveModel masterSlave;

    private SentinelModel sentinel;

    private ClusterModel cluster;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class SingleModel {
        private String host;

        private int port;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class MasterSlaveModel {
        private String master;
        private String nodes;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class SentinelModel {
        private String master;
        private String nodes;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ClusterModel {
        private String nodes;
    }
}
