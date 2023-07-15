package com.steven.cns.common.web.exception;

import com.steven.cns.common.web.type.IApiResult;
import lombok.Data;

import java.io.Serial;

/**
 * 自定义业务异常
 *
 * @author: steven
 * @date: 2023/7/15 10:48
 */
@Data
public class BizException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String code;

    private final String msg;

    public BizException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(IApiResult iApiResult) {
        super(iApiResult.getMsg());
        this.code = iApiResult.getCode();
        this.msg = iApiResult.getMsg();
    }
}
