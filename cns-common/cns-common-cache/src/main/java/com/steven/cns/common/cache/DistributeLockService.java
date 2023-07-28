package com.steven.cns.common.cache;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: steven
 * @date: 2023/7/26 21:45
 */
@Component
@ConditionalOnBean(RedissonClient.class)
@RequiredArgsConstructor
public class DistributeLockService {

    private final RedissonClient redissonClient;

    public <T> T executeWithLockThrows(String key, long expire, TimeUnit timeUnit, SupplierThrows<T> supplier)
            throws Throwable {
        RLock lock = redissonClient.getLock(key);
        boolean locked = lock.tryLock(expire, timeUnit);
        if (!locked) {
            throw new RuntimeException("获取锁失败");
        }
        try {
            return supplier.get();
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
