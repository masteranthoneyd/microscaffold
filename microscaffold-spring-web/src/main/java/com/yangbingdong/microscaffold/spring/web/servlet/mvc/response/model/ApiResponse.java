package com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model;

import lombok.Data;
import lombok.experimental.Accessors;

import static com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.ApiResponseConstants.GLOBAL_SUCCESS_CODE;
import static com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.ApiResponseConstants.GLOBAL_SUCCESS_MSG;

/**
 * @author yangbingdong1994@gmail.com
 */
@Data
@Accessors(chain = true)
public class ApiResponse {

    private String code;

    private Object body;

    private String msg;

    public static ApiResponse ok(Object body) {
        return new ApiResponse()
                .setBody(body)
                .setCode(GLOBAL_SUCCESS_CODE)
                .setMsg(GLOBAL_SUCCESS_MSG);
    }

    public static ApiResponse ok() {
        return ok(null);
    }

    public static ApiResponse fail(GlobalBaseException ex) {
        return fail(ex.getMsg(), ex.getCode());
    }

    public static ApiResponse fail(String msg, String code) {
        return new ApiResponse()
                .setCode(code)
                .setMsg(msg);
    }

    public static ApiResponse fail(String msg) {
        return fail(msg, GLOBAL_SUCCESS_CODE);
    }
}
