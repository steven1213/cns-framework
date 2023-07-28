package com.steven.cns.redis.spring.boot.starter;

import lombok.Getter;

@Getter
public enum RedisModel {
    SINGER("单机模式"),
    CLUSTER("集群模式"),
    SENTINEL("哨兵模式"),
    MASTER_SLAVE("主从模式");

    private final String desc;

    RedisModel(String desc) {
        this.desc = desc;
    }
}
