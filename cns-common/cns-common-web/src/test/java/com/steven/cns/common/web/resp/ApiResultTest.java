package com.steven.cns.common.web.resp;

import com.steven.cns.common.web.type.IApiResult;
import lombok.Getter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApiResultTest {

    @Test
    @DisplayName("success()方法测试")
    void success() {
        ApiResult<?> result = ApiResult.success();
        assert result.getCode().equals("200");
    }

    @Test
    @DisplayName("success(T data)方法测试")
    void testSuccess() {
        ApiResult<?> result = ApiResult.success("test");
        assert result.getCode().equals("200") && result.getData().equals("test");
    }


    @Test
    @DisplayName("success(IApiResult iApiResult)方法测试")
    void testSuccess1() {
        ApiResult<?> result = ApiResult.success(CustomerResultEnum.SUCCESS);
        assert result.getCode().equals("0");
    }

    @Test
    @DisplayName("success(IApiResult iApiResult, T data)方法测试")
    void testSuccess2() {
        ApiResult<?> result = ApiResult.success(CustomerResultEnum.SUCCESS, "test");
        assert result.getCode().equals("0") && result.getData().equals("test");
    }

    @Test
    @DisplayName("success(String code, String msg)方法测试")
    void testSuccess3() {
        ApiResult<?> result = ApiResult.success("0", "success");
        assert result.getCode().equals("0") && result.getMsg().equals("success");
    }

    @Test
    @DisplayName("success(String code, String msg, T data)方法测试")
    void testSuccess4() {
        ApiResult<?> result = ApiResult.success("0", "success", "test");
        assert result.getCode().equals("0") && result.getData().equals("test");
    }

    @Test
    @DisplayName("fail()方法测试")
    void fail() {
        ApiResult<?> result = ApiResult.fail();
        assert result.getCode().equals("500");
    }

    @Test
    @DisplayName("fail(T data)方法测试")
    void testFail() {
        ApiResult<?> result = ApiResult.fail("test");
        assert result.getCode().equals("500") && result.getData().equals("test");
    }

    @Test
    @DisplayName("fail(IApiResult iApiResult)方法测试")
    void testFail1() {
        ApiResult<?> result = ApiResult.fail(CustomerResultEnum.FAIL);
        assert result.getCode().equals("-1");
    }

    @Test
    @DisplayName("fail(IApiResult iApiResult, T data)方法测试")
    void testFail2() {
        ApiResult<?> result = ApiResult.fail(CustomerResultEnum.FAIL, "test");
        assert result.getCode().equals("-1") && result.getData().equals("test");
    }

    @Test
    @DisplayName("fail(String code, String msg)方法测试")
    void testFail3() {
        ApiResult<?> result = ApiResult.fail("500", "failure");
        assert result.getCode().equals("500") && result.getMsg().equals("failure");
    }

    @Test
    @DisplayName("fail(String code, String msg, T data)方法测试")
    void testFail4() {
        ApiResult<?> result = ApiResult.fail("500", "failure", "test");
        assert result.getCode().equals("500") && result.getData().equals("test");
    }

    @Getter
    public enum CustomerResultEnum implements IApiResult {
        SUCCESS("0", "success"), FAIL("-1", "fail"),
        ;

        private final String code;

        private final String msg;

        CustomerResultEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
}