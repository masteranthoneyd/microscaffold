package com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model;

/**
 * @author yangbingdong1994@gmail.com
 */
public class ClientException extends GlobalBaseException {

    public ClientException() {
    }

    public ClientException(String code, String msg) {
        super(code, msg);
    }

    public ClientException(String code, String msg, Throwable cause) {
        super(code, msg, cause);
    }

    public ClientException(String msg) {
        super(msg);
    }
}
