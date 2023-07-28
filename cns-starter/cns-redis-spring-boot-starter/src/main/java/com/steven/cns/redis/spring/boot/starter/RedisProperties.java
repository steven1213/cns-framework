package com.steven.cns.redis.spring.boot.starter;

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
@ConfigurationProperties(prefix = RedisProperties.REDIS_PREFIX)
public class RedisProperties {
    public static final String REDIS_PREFIX = "cns.spring.redis";

    /**
     * redis 部署模式
     *
     * @see RedisModel
     */
    private RedisModel mode;

    /**
     * redis 数据库
     */
    private int database;

    /**
     * redis 密码
     */
    private String password;

    /**
     * redis 单机模式配置
     */
    private SingleModel single;

    /**
     * redis 主从模式配置
     */
    private MasterSlaveModel masterSlave;

    /**
     * redis 哨兵模式配置
     */
    private SentinelModel sentinel;

    /**
     * redis 集群模式配置
     */
    private ClusterModel cluster;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class SingleModel {
        private String host = "localhost";

        private int port = 6379;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class MasterSlaveModel {
        private Master master;
        private String slaves;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Master {
        private String host;
        private int port;
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

    public void masterSlaveModelParamCheck() {
        ParameterCheckUtils.checkNotBlank("master host", masterSlave.getMaster().getHost());
    }

    public void sentinelModelParamCheck() {
        ParameterCheckUtils.checkNotBlank("master name", sentinel.getMaster());
        ParameterCheckUtils.checkNotBlank("sentinel nodes", sentinel.getNodes());
    }

    public void clusterModelParamCheck() {
        ParameterCheckUtils.checkNotBlank("cluster nodes", cluster.getNodes());
    }
}
