package com.yangbingdong.microscaffold.spring.web.servlet.mvc.response;

import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model.ApiResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author yangbingdong1994@gmail.com
 */
@ControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (body == null) {
            return ApiResponse.ok();
        }
        if (body instanceof ApiResponse ||
                body instanceof String ||
                ClassUtils.isPrimitiveOrWrapper(body.getClass())) {
            return body;
        }
        return ApiResponse.ok(body);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
