package com.steven.cns.redis.spring.boot.starter;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.*;

/**
 * @author: steven
 * @date: 2023/7/26 23:41
 */
public class RedissonClientBuilder {
    public static RedissonClient buildSingle(RedisProperties redisProperties) {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress(Constants.REDIS_PREFIX + redisProperties.getSingle().getHost() +
                Constants.COLON + redisProperties.getSingle().getPort());
        singleServerConfig.setDatabase(redisProperties.getDatabase());
        singleServerConfig.setPassword(redisProperties.getPassword());

        return Redisson.create(config);
    }

    public static RedissonClient buildCluster(RedisProperties redisProperties) {
        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers();
        clusterServersConfig.addNodeAddress(redisProperties.getCluster().getNodes().split(Constants.SEMICOLON));
        clusterServersConfig.setPassword(redisProperties.getPassword());
        return Redisson.create(config);
    }

    public static RedissonClient buildSentinel(RedisProperties redisProperties) {
        Config config = new Config();
        SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
        sentinelServersConfig.setDatabase(redisProperties.getDatabase());
        sentinelServersConfig.setMasterName(redisProperties.getSentinel().getMaster());
        sentinelServersConfig.addSentinelAddress(redisProperties.getSentinel().getNodes().split(Constants.SEMICOLON));
        sentinelServersConfig.setPassword(redisProperties.getPassword());

        return Redisson.create(config);
    }

    public static RedissonClient buildMasterSlave(RedisProperties redisProperties) {
        Config config = new Config();
        MasterSlaveServersConfig masterSlaveServersConfig = config.useMasterSlaveServers();
        masterSlaveServersConfig.setMasterAddress(Constants.REDIS_PREFIX +
                redisProperties.getMasterSlave().getMaster().getHost() + Constants.COLON +
                redisProperties.getMasterSlave().getMaster().getPort());
        masterSlaveServersConfig.setDatabase(redisProperties.getDatabase());
        masterSlaveServersConfig.setPassword(redisProperties.getPassword());
        masterSlaveServersConfig.addSlaveAddress(redisProperties.getMasterSlave().getSlaves().split(Constants.SEMICOLON));
        return Redisson.create(config);
    }
}
