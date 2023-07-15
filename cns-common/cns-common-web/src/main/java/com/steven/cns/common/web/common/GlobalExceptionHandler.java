package com.steven.cns.common.web.common;

import com.steven.cns.common.web.exception.BizException;
import com.steven.cns.common.web.resp.ApiResult;
import com.steven.cns.common.web.type.CnsApiResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author: steven
 * @date: 2023/7/15 10:18
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ApiResult<?> exceptionHandler(Exception e) {
        log.error("全局异常处理：", e);
        return ApiResult.fail();
    }

    /**
     * 自定义业务异常处理
     */
    @ExceptionHandler(value = BizException.class)
    public ApiResult<?> bizExceptionHandler(BizException e) {
        log.error("自定义业务异常处理：", e);
        return ApiResult.fail(e.getCode(), e.getMsg());
    }

    /**
     * 参数绑定异常处理
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ApiResult<?> illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error("参数绑定异常处理：", e);
        return ApiResult.fail(CnsApiResultEnum.FAIL.getCode(), e.getMessage());
    }

    /**
     * validator 参数校验异常处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ApiResult<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("validator 参数校验异常处理：", e);
        return ApiResult.fail(CnsApiResultEnum.FAIL.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }
}
