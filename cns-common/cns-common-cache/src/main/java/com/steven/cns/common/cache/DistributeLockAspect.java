package com.steven.cns.common.cache;

import com.steven.cns.common.tool.utils.SpELUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: steven
 * @date: 2023/7/26 21:30
 */
@Component
@ConditionalOnBean(DistributeLockService.class)
@Slf4j
@RequiredArgsConstructor
public class DistributeLockAspect {

    private final DistributeLockService distributeLockService;

    @Around("@annotation(com.steven.cns.common.cache.DistributeLock)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        DistributeLock distributeLock = method.getAnnotation(DistributeLock.class);
        String prefix = StringUtils.isBlank(distributeLock.prefix()) ?
                method.getDeclaringClass().getName() : distributeLock.prefix();
        String key = SpELUtils.parseSpEL(distributeLock.key(), method, joinPoint.getArgs());
        return distributeLockService.executeWithLockThrows(prefix + ":" + key,
                distributeLock.expire(), distributeLock.timeUnit(), joinPoint::proceed);
    }
}
