package com.steven.cns.redis.spring.boot.starter;

/**
 * @author: steven
 * @date: 2023/7/27 19:45
 */
public final class ParameterCheckUtils {
    public static void checkNotBlank(String masterHost, String host) {
        if (masterHost == null || masterHost.trim().length() == 0) {
            throw new IllegalArgumentException("masterHost is blank");
        }
        if (host == null || host.trim().length() == 0) {
            throw new IllegalArgumentException("host is blank");
        }
    }
}
