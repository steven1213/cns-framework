package com.steven.cns.common.web.type;

import lombok.Getter;

@Getter
public enum CnsApiResultEnum implements IApiResult {

    SUCCESS("200", "success"),
    FAIL("500", "fail"),

    // 1000-1999 通用错误

    // 2000-2999 用户错误

    // 3000-3999 接口错误

    // 4000-4999 权限错误

    // 5000-5999 数据错误

    // 6000-6999 业务错误

    // 7000-7999 系统错误

    // 8000-8999 第三方错误

    // 9000-9999 未知错误
    UNKNOWN_ERROR("9999", "未知错误"),

    ;

    private final String code;

    private final String msg;

    CnsApiResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
