package com.steven.cns.common.tool.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Slf4j
class AppUtilsTest {
    @Test
    @DisplayName("获取appId")
    void getAppId() {
        String appId = AppUtils.getAppId();
        log.info("appId: {}", appId);
        assert appId.length() == 8;
    }

    @Test
    @DisplayName("获取appSecret")
    void getAppSecret() {
        String appId = AppUtils.getAppId();
        String appSecret = AppUtils.getAppSecret(appId);
        log.info("appId: {}, appSecret: {}", appId, appSecret);
        assert appSecret.length() == 40;
    }
}