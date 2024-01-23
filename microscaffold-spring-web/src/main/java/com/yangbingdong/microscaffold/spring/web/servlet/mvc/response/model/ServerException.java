package com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model;

/**
 * @author yangbingdong1994@gmail.com
 */
public class ServerException extends GlobalBaseException {

    public ServerException() {
    }

    public ServerException(String code, String msg) {
        super(code, msg);
    }

    public ServerException(String code, String msg, Throwable cause) {
        super(code, msg, cause);
    }
}
