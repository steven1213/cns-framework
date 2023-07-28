package com.steven.cns.common.cache;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DistributeLock {

    /**
     * 锁前缀 默认使用类的
     */
    String prefix() default "";

    /**
     * 锁key EL表达示
     */
    String key();

    /**
     * 锁过期时间 默认5秒
     */
    long expire() default 5L;

    /**
     * 时间单位
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
