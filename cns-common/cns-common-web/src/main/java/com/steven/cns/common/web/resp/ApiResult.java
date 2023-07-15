package com.steven.cns.common.web.resp;

import com.steven.cns.common.web.type.CnsApiResultEnum;
import com.steven.cns.common.web.type.IApiResult;
import lombok.Data;

/**
 * @author: steven
 * @date: 2023/7/15 09:33
 */
@Data
public class ApiResult<T> {
    private String code;

    private String msg;

    private T data;

    public static <T> ApiResult<T> success(T data) {
        return build(CnsApiResultEnum.SUCCESS.getCode(), CnsApiResultEnum.SUCCESS.getMsg(), data);
    }

    public static <T> ApiResult<T> success() {
        return build(CnsApiResultEnum.SUCCESS.getCode(), CnsApiResultEnum.SUCCESS.getMsg(), null);
    }

    public static <T> ApiResult<T> success(IApiResult iApiResult) {
        return build(iApiResult.getCode(), iApiResult.getMsg(), null);
    }

    public static <T> ApiResult<T> success(String code, String msg) {
        return build(code, msg, null);
    }

    public static <T> ApiResult<T> success(IApiResult iApiResult, T data) {
        return build(iApiResult.getCode(), iApiResult.getMsg(), data);
    }

    public static <T> ApiResult<T> success(String code, String msg, T data) {
        return build(code, msg, data);
    }

    public static <T> ApiResult<T> fail() {
        return build(CnsApiResultEnum.FAIL.getCode(), CnsApiResultEnum.FAIL.getMsg(), null);
    }


    public static <T> ApiResult<T> fail(IApiResult iApiResult) {
        return build(iApiResult.getCode(), iApiResult.getMsg(), null);
    }

    public static <T> ApiResult<T> fail(String code, String msg) {
        return build(code, msg, null);
    }

    public static <T> ApiResult<T> fail(T data) {
        return build(CnsApiResultEnum.FAIL.getCode(), CnsApiResultEnum.FAIL.getMsg(), data);
    }

    public static <T> ApiResult<T> fail(IApiResult iApiResult, T data) {
        return build(iApiResult.getCode(), iApiResult.getMsg(), data);
    }

    public static <T> ApiResult<T> fail(String code, String msg, T data) {
        return build(code, msg, data);
    }

    private static <T> ApiResult<T> build(String code, String msg, T data) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(code);
        apiResult.setMsg(msg);
        apiResult.setData(data);
        return apiResult;
    }
}
