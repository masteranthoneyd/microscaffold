package com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model;

import lombok.Getter;

import static com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.ApiResponseConstants.GLOBAL_ERROR_CODE;
import static com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.ApiResponseConstants.GLOBAL_ERROR_MSG;

/**
 * @author yangbingdong1994@gmail.com
 */
@Getter
public class GlobalBaseException extends RuntimeException {

    private String code = GLOBAL_ERROR_CODE;
    private String msg = GLOBAL_ERROR_MSG;

    public GlobalBaseException() {
    }

    public GlobalBaseException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public GlobalBaseException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }
}
